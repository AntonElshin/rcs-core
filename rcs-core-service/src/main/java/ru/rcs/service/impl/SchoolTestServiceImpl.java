package ru.rcs.service.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rcs.dto.SchoolTestReqDTO;
import ru.rcs.dto.SchoolTestResDTO;
import ru.rcs.entity.QSchoolTest;
import ru.rcs.entity.SchoolClass;
import ru.rcs.entity.SchoolTest;
import ru.rcs.entity.Subject;
import ru.rcs.exception.BusinessException;
import ru.rcs.exception.Errors;
import ru.rcs.mapper.SchoolTestMapper;
import ru.rcs.repository.SchoolClassRepository;
import ru.rcs.repository.SchoolTestRepository;
import ru.rcs.repository.SubjectRepository;
import ru.rcs.service.SchoolTestService;

@Service
@RequiredArgsConstructor
public class SchoolTestServiceImpl implements SchoolTestService {

  private final SchoolTestRepository schoolTestRepository;
  private final SchoolClassRepository schoolClassRepository;
  private final SubjectRepository subjectRepository;

  private final SchoolTestMapper schoolTestMapper;

  @Override
  public List<SchoolTestResDTO> find(UUID schoolTestClassId, UUID schoolTestSubjectId) {

    List<BooleanExpression> predicates = new ArrayList<>();

    if(schoolTestClassId != null) {
      predicates.add(QSchoolTest.schoolTest.schoolClass.id.eq(String.valueOf(schoolTestClassId)));
    }
    if(schoolTestSubjectId != null) {
      predicates.add(QSchoolTest.schoolTest.subject.id.eq(String.valueOf(schoolTestSubjectId)));
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
  public SchoolTestResDTO findById(UUID schoolTestId) {

    if(schoolTestId == null) {
      throw new BusinessException(Errors.MISSING_REQUIRED_PARAM_SCHOOL_TEST_ID);
    }

    SchoolTest schoolTest = schoolTestRepository.findById(String.valueOf(schoolTestId))
        .orElseThrow(() -> new BusinessException(Errors.SCHOOL_TEST_NOT_FOUND_BY_ID, schoolTestId));

    return schoolTestMapper.toDto(schoolTest);
  }

  @Override
  public SchoolTestResDTO add(SchoolTestReqDTO schoolTestReqDTO) {

    SchoolTest schoolTest = fillSchoolTest(null, schoolTestReqDTO);
    schoolTest = schoolTestRepository.save(schoolTest);

    return schoolTestMapper.toDto(schoolTest);

  }

  @Override
  public SchoolTestResDTO modify(UUID schoolTestId, SchoolTestReqDTO schoolTestReqDTO) {

    SchoolTest schoolTest = fillSchoolTest(schoolTestId, schoolTestReqDTO);
    schoolTest = schoolTestRepository.save(schoolTest);

    return schoolTestMapper.toDto(schoolTest);

  }

  @Override
  public void remove(UUID schoolTestId) {

    if(schoolTestId == null) {
      throw new BusinessException(Errors.MISSING_REQUIRED_PARAM_SCHOOL_TEST_ID);
    }

    SchoolTest schoolTest = schoolTestRepository.findById(String.valueOf(schoolTestId)).orElseThrow(() -> new BusinessException(Errors.SCHOOL_TEST_NOT_FOUND_BY_ID, schoolTestId));
    //TODO: проверить наличие результатов тестов ...
    schoolTestRepository.delete(schoolTest);
  }

  private SchoolTest fillSchoolTest(UUID schoolTestId, SchoolTestReqDTO schoolTestReqDTO) {

    SchoolTest schoolTest;

    if(schoolTestId != null) {
      schoolTest = schoolTestRepository.findById(String.valueOf(schoolTestId)).orElseThrow(() -> new BusinessException(Errors.SCHOOL_TEST_NOT_FOUND_BY_ID, schoolTestId));
    }
    else {
      schoolTest = new SchoolTest();
    }

    UUID schoolClassId = schoolTestReqDTO.getSchoolClassId();
    if(schoolClassId == null) {
      throw new BusinessException(Errors.MISSING_REQUIRED_PARAM_SCHOOL_CLASS_ID);
    }
    SchoolClass schoolClass = schoolClassRepository.findById(String.valueOf(schoolClassId)).orElseThrow(() -> new BusinessException(Errors.SCHOOL_CLASS_NOT_FOUND_BY_ID, schoolClassId));
    schoolTest.setSchoolClass(schoolClass);

    UUID subjectId = schoolTestReqDTO.getSubjectId();
    if(subjectId == null) {
      throw new BusinessException(Errors.MISSING_REQUIRED_PARAM_SUBJECT_ID);
    }
    Subject subject = subjectRepository.findById(String.valueOf(subjectId)).orElseThrow(() -> new BusinessException(Errors.SUBJECT_NOT_FOUND_BY_ID, subjectId));
    schoolTest.setSubject(subject);

    String displayName = schoolTestReqDTO.getDisplayName();
    if(displayName != null) {
      schoolTest.setDisplayName(displayName);
    }

    return schoolTest;
  }
}