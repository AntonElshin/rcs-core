package ru.rcs.service.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rcs.dto.SchoolTestDTO;
import ru.rcs.dto.SchoolTestTextDTO;
import ru.rcs.entity.QSchoolTest;
import ru.rcs.entity.SchoolClass;
import ru.rcs.entity.SchoolTest;
import ru.rcs.entity.SchoolTestText;
import ru.rcs.entity.Subject;
import ru.rcs.exception.BusinessException;
import ru.rcs.exception.Errors;
import ru.rcs.mapper.SchoolTestMapper;
import ru.rcs.mapper.SchoolTestTextMapper;
import ru.rcs.repository.SchoolClassRepository;
import ru.rcs.repository.SchoolTestRepository;
import ru.rcs.repository.SchoolTestTextRepository;
import ru.rcs.repository.SubjectRepository;
import ru.rcs.service.SchoolTestService;
import ru.rcs.service.SchoolTestTextService;

@Service
@RequiredArgsConstructor
public class SchoolTestServiceImpl implements SchoolTestService {

  private final SchoolTestRepository schoolTestRepository;
  private final SchoolClassRepository schoolClassRepository;
  private final SubjectRepository subjectRepository;
  private final SchoolTestTextService schoolTestTextService;

  private final SchoolTestMapper schoolTestMapper;
  private final SchoolTestTextMapper schoolTestTextMapper;

  @Override
  @Transactional(readOnly = true)
  public List<SchoolTestDTO> find(UUID searchSchoolClassId, UUID searchSubjectId) {

    List<BooleanExpression> predicates = new ArrayList<>();

    if(searchSchoolClassId != null) {
      predicates.add(QSchoolTest.schoolTest.schoolClass.id.eq(String.valueOf(searchSchoolClassId)));
    }
    if(searchSubjectId != null) {
      predicates.add(QSchoolTest.schoolTest.subject.id.eq(String.valueOf(searchSubjectId)));
    }

    List<SchoolTest> schoolTests;

    if(predicates.size() == 0) {
      schoolTests = schoolTestRepository.findAll();
    }
    else if(predicates.size() == 1) {
      schoolTests = schoolTestRepository.findAll(predicates.get(0));
    }
    else {
      BooleanExpression fullPredicate = predicates.get(0);
      int index = 0;
      for(BooleanExpression predicate : predicates) {
        if(index < predicates.size() - 1) {
          index++;
          fullPredicate = fullPredicate.and(predicates.get(index));
        }
      }
      schoolTests = schoolTestRepository.findAll(fullPredicate);
    }

    return schoolTestMapper.toListDto(schoolTests);
  }

  @Override
  @Transactional(readOnly = true)
  public SchoolTestDTO findById(UUID schoolTestId) {

    if(schoolTestId == null) {
      throw new BusinessException(Errors.MISSING_REQUIRED_PARAM_SCHOOL_TEST_ID);
    }

    SchoolTest schoolTest = schoolTestRepository.findById(String.valueOf(schoolTestId))
        .orElseThrow(() -> new BusinessException(Errors.SCHOOL_TEST_NOT_FOUND_BY_ID, schoolTestId));

    return schoolTestMapper.toDto(schoolTest);
  }

  @Override
  @Transactional
  public SchoolTestDTO add(SchoolTestDTO schoolTestDTO) {

    SchoolTest schoolTest = fillSchoolTest(null, schoolTestDTO);
    schoolTest = schoolTestRepository.save(schoolTest);

    if(schoolTestDTO.getSchoolTestText() != null) {
      SchoolTestTextDTO schoolTestTextDTO = schoolTestTextService.create(schoolTest, schoolTestDTO.getSchoolTestText());
      schoolTest.setSchoolTestText(schoolTestTextMapper.fromDto(schoolTestTextDTO));
    }

    return schoolTestMapper.toDto(schoolTest);
  }

  @Override
  @Transactional
  public SchoolTestDTO modify(UUID schoolTestId, SchoolTestDTO schoolTestDTO) {

    SchoolTest schoolTest = fillSchoolTest(schoolTestId, schoolTestDTO);
    schoolTest = schoolTestRepository.save(schoolTest);

    // Текст для школьного теста
    SchoolTestText schoolTestText = schoolTest.getSchoolTestText();
    SchoolTestTextDTO schoolTestTextDTO = schoolTestDTO.getSchoolTestText();

    if(schoolTestText != null) {
      if(schoolTestTextDTO == null) {
        schoolTestTextService.remove(UUID.fromString(schoolTestText.getId()));
        schoolTest.setSchoolTestText(null);
      }
      else {
        schoolTestTextService.modify(UUID.fromString(schoolTestText.getId()), schoolTestTextDTO);
      }
    }
    else if(schoolTestTextDTO != null) {
      schoolTestTextService.create(schoolTest, schoolTestTextDTO);
    }

    return schoolTestMapper.toDto(schoolTest);

  }

  @Override
  @Transactional
  public void remove(UUID schoolTestId) {

    if(schoolTestId == null) {
      throw new BusinessException(Errors.MISSING_REQUIRED_PARAM_SCHOOL_TEST_ID);
    }

    SchoolTest schoolTest = schoolTestRepository.findById(String.valueOf(schoolTestId)).orElseThrow(() -> new BusinessException(Errors.SCHOOL_TEST_NOT_FOUND_BY_ID, schoolTestId));
    //TODO: проверить наличие результатов тестов ...
    schoolTestRepository.delete(schoolTest);
  }

  private SchoolTest fillSchoolTest(UUID schoolTestId, SchoolTestDTO schoolTestDTO) {

    SchoolTest schoolTest;

    if(schoolTestId != null) {
      schoolTest = schoolTestRepository.findById(String.valueOf(schoolTestId)).orElseThrow(() -> new BusinessException(Errors.SCHOOL_TEST_NOT_FOUND_BY_ID, schoolTestId));
    }
    else {
      schoolTest = new SchoolTest();
    }

    UUID schoolClassId = schoolTestDTO.getSchoolClass().getId();
    if(schoolClassId == null) {
      throw new BusinessException(Errors.MISSING_REQUIRED_PARAM_SCHOOL_CLASS_ID);
    }
    SchoolClass schoolClass = schoolClassRepository.findById(String.valueOf(schoolClassId)).orElseThrow(() -> new BusinessException(Errors.SCHOOL_CLASS_NOT_FOUND_BY_ID, schoolClassId));
    schoolTest.setSchoolClass(schoolClass);

    UUID subjectId = schoolTestDTO.getSubject().getId();
    if(subjectId == null) {
      throw new BusinessException(Errors.MISSING_REQUIRED_PARAM_SUBJECT_ID);
    }
    Subject subject = subjectRepository.findById(String.valueOf(subjectId)).orElseThrow(() -> new BusinessException(Errors.SUBJECT_NOT_FOUND_BY_ID, subjectId));
    schoolTest.setSubject(subject);

    String displayName = schoolTestDTO.getDisplayName();
    if(displayName != null) {
      schoolTest.setDisplayName(displayName);
    }

    return schoolTest;
  }
}
