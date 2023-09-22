package ru.rcs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rcs.dto.SchoolClassDTO;
import ru.rcs.entity.QSchoolTest;
import ru.rcs.entity.SchoolClass;
import ru.rcs.entity.SchoolTest;
import ru.rcs.exception.BusinessException;
import ru.rcs.exception.Errors;
import ru.rcs.mapper.SchoolClassMapper;
import ru.rcs.repository.SchoolClassRepository;
import ru.rcs.repository.SchoolTestRepository;
import ru.rcs.service.SchoolClassService;

@Service
@RequiredArgsConstructor
public class SchoolClassServiceImpl implements SchoolClassService {

  private final SchoolClassRepository schoolClassRepository;
  private final SchoolClassMapper schoolClassMapper;
  private final SchoolTestRepository schoolTestRepository;

  @Override
  @Transactional(readOnly = true)
  public List<SchoolClassDTO> find(String search) {
    List<SchoolClass> schoolClasses;
    if(search != null && !search.isEmpty()) {
      schoolClasses = schoolClassRepository.find(search);
    }
    else {
      schoolClasses = schoolClassRepository.findAll();
    }
    return schoolClassMapper.toListDto(schoolClasses);
  }

  @Override
  @Transactional(readOnly = true)
  public SchoolClassDTO findById(UUID schoolClassId) {
    SchoolClass schoolClass = schoolClassRepository.getById(String.valueOf(schoolClassId));
    return schoolClassMapper.toDto(schoolClass);
  }

  @Override
  @Transactional
  public SchoolClassDTO add(SchoolClassDTO schoolClassDTO) {
    SchoolClass schoolClass = schoolClassMapper.fromDto(schoolClassDTO);
    schoolClass = schoolClassRepository.save(schoolClass);
    return schoolClassMapper.toDto(schoolClass);
  }

  @Override
  @Transactional
  public SchoolClassDTO modify(UUID schoolClassId, SchoolClassDTO schoolClassDTO) {
    SchoolClass schoolClass = schoolClassRepository.getById(String.valueOf(schoolClassId));

    schoolClass.setSystemName(schoolClassDTO.getSystemName());
    schoolClass.setName(schoolClassDTO.getName());
    schoolClass.setDescription(schoolClassDTO.getDescription());

    schoolClass = schoolClassRepository.save(schoolClass);
    return schoolClassMapper.toDto(schoolClass);
  }

  @Override
  @Transactional
  public void remove(UUID schoolClassId) {
    SchoolClass schoolClass = schoolClassRepository.getById(String.valueOf(schoolClassId));

    //TODO: можно проверять по констрейнту в БД
    List<SchoolTest> schoolTests = schoolTestRepository.findAll(QSchoolTest.schoolTest.schoolClass.id.eq(String.valueOf(schoolClassId)));

    if(schoolTests.size() > 0) {
      throw new BusinessException(Errors.SCHOOL_CLASS_HAS_LINKED_TESTS, schoolClassId);
    }

    schoolClassRepository.delete(schoolClass);
  }
}
