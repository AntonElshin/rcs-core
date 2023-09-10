package ru.rcs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rcs.dto.SchoolClassDTO;
import ru.rcs.entity.SchoolClass;
import ru.rcs.mapper.SchoolClassMapper;
import ru.rcs.repository.SchoolClassRepository;
import ru.rcs.service.SchoolClassService;

@Service
@RequiredArgsConstructor
public class SchoolClassServiceImpl implements SchoolClassService {

  private final SchoolClassRepository schoolClassRepository;
  private final SchoolClassMapper schoolClassMapper;

  @Override
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
  @Transactional
  public SchoolClassDTO getById(UUID schoolClassId) {
    SchoolClass schoolClass = schoolClassRepository.getById(String.valueOf(schoolClassId));
    return schoolClassMapper.toDto(schoolClass);
  }

  @Override
  @Transactional
  public SchoolClassDTO add(SchoolClassDTO schoolClassDTO) {
    SchoolClass schoolClass = schoolClassMapper.fromDto(schoolClassDTO);
    SchoolClass addedSchoolClass = schoolClassRepository.save(schoolClass);
    return schoolClassMapper.toDto(addedSchoolClass);
  }

  @Override
  @Transactional
  public SchoolClassDTO modify(UUID schoolClassId, SchoolClassDTO schoolClassDTO) {
    SchoolClass foundSchoolClass = schoolClassRepository.getById(String.valueOf(schoolClassId));

    if(schoolClassDTO.getSystemName() != null) {
      foundSchoolClass.setSystemName(schoolClassDTO.getSystemName());
    }
    if(schoolClassDTO.getName() != null) {
      foundSchoolClass.setName(schoolClassDTO.getName());
    }
    if(schoolClassDTO.getDescription() != null) {
      foundSchoolClass.setDescription(schoolClassDTO.getDescription());
    }

    SchoolClass modifiedSchoolClass = schoolClassRepository.save(foundSchoolClass);
    return schoolClassMapper.toDto(modifiedSchoolClass);
  }

  @Override
  @Transactional
  public void remove(UUID schoolClassId) {
    SchoolClass schoolClass = schoolClassRepository.getById(String.valueOf(schoolClassId));
    schoolClassRepository.delete(schoolClass);
  }
}
