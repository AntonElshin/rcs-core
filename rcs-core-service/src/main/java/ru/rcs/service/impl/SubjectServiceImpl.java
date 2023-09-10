package ru.rcs.service.impl;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rcs.dto.SubjectDTO;
import ru.rcs.entity.Subject;
import ru.rcs.mapper.SubjectMapper;
import ru.rcs.repository.SubjectRepository;
import ru.rcs.service.SubjectService;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

  private final SubjectRepository subjectRepository;
  private final SubjectMapper subjectMapper;
  
  @Override
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
  public SubjectDTO getById(UUID subjectId) {
    Subject subject = subjectRepository.getById(String.valueOf(subjectId));
    return subjectMapper.toDto(subject);
  }

  @Override
  public SubjectDTO add(SubjectDTO subjectDTO) {
    Subject subject = subjectMapper.fromDto(subjectDTO);
    Subject addedSubject = subjectRepository.save(subject);
    return subjectMapper.toDto(addedSubject);
  }

  @Override
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
  public void remove(UUID subjectId) {
    Subject subject = subjectRepository.getById(String.valueOf(subjectId));
    subjectRepository.delete(subject);
  }
}
