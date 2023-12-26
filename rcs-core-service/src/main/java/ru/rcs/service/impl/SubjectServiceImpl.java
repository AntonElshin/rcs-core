package ru.rcs.service.impl;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rcs.dto.SubjectDTO;
import ru.rcs.entity.QSchoolTest;
import ru.rcs.entity.SchoolTest;
import ru.rcs.entity.Subject;
import ru.rcs.exception.BusinessException;
import ru.rcs.exception.Errors;
import ru.rcs.mapper.SubjectMapper;
import ru.rcs.repository.SchoolTestRepository;
import ru.rcs.repository.SubjectRepository;
import ru.rcs.service.SubjectService;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

  private final SubjectRepository subjectRepository;
  private final SubjectMapper subjectMapper;
  private final SchoolTestRepository schoolTestRepository;
  
  @Override
  @Transactional(readOnly = true)
  public List<SubjectDTO> find(String search) {
    List<Subject> subjects;
    if(search != null && !search.isEmpty()) {
      subjects = subjectRepository.find(search);
    }
    else {
      subjects = subjectRepository.findAll();
    }
    return subjectMapper.toListDto(subjects);
  }

  @Override
  @Transactional(readOnly = true)
  public SubjectDTO findById(UUID subjectId) {
    Subject subject = subjectRepository.findById(String.valueOf(subjectId))
        .orElseThrow(() -> new BusinessException(Errors.SUBJECT_NOT_FOUND_BY_ID, subjectId));
    return subjectMapper.toDto(subject);
  }

  @Override
  @Transactional
  public SubjectDTO add(SubjectDTO subjectDTO) {
    Subject subject = subjectMapper.fromDto(subjectDTO);
    Subject addedSubject = subjectRepository.save(subject);
    return subjectMapper.toDto(addedSubject);
  }

  @Override
  @Transactional
  public SubjectDTO modify(UUID subjectId, SubjectDTO subjectDTO) {
    Subject foundSubject = subjectRepository.getById(String.valueOf(subjectId));

    if(subjectDTO.getSystemName() != null) {
      foundSubject.setSystemName(subjectDTO.getSystemName());
    }
    if(subjectDTO.getName() != null) {
      foundSubject.setName(subjectDTO.getName());
    }
    if(subjectDTO.getDescription() != null) {
      foundSubject.setDescription(subjectDTO.getDescription());
    }


    Subject modifiedSubject = subjectRepository.save(foundSubject);
    return subjectMapper.toDto(modifiedSubject);
  }

  @Override
  @Transactional
  public void remove(UUID subjectId) {

    if(subjectId == null) {
      throw new BusinessException(Errors.MISSING_REQUIRED_PARAM_SUBJECT_ID);
    }

    Subject subject = subjectRepository.findById(String.valueOf(subjectId))
        .orElseThrow(() -> new BusinessException(Errors.SUBJECT_NOT_FOUND_BY_ID, subjectId));

    //TODO: можно проверять по констрейнту в БД
    List<SchoolTest> schoolTests = schoolTestRepository.findAll(QSchoolTest.schoolTest.subject.id.eq(String.valueOf(subjectId)));

    if(schoolTests.size() > 0) {
      throw new BusinessException(Errors.SUBJECT_HAS_LINKED_TESTS, subjectId);
    }


    subjectRepository.delete(subject);
  }
}
