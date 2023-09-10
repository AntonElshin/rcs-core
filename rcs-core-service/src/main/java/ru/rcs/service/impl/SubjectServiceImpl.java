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
    List<Subject> subjects = subjectRepository.find(search);
    return subjectMapper.toListDto(subjects);
  }

  @Override
  public SubjectDTO getById(UUID subjectId) {
    Subject Subject = subjectRepository.getById(String.valueOf(subjectId));
    return subjectMapper.toDto(Subject);
  }

  @Override
  public SubjectDTO add(SubjectDTO subjectDTO) {
    Subject Subject = subjectMapper.fromDto(subjectDTO);
    Subject addedSubject = subjectRepository.save(Subject);
    return subjectMapper.toDto(addedSubject);
  }

  @Override
  public SubjectDTO modify(UUID subjectId, SubjectDTO subjectDTO) {
    Subject Subject = subjectMapper.fromDto(subjectDTO);
    Subject.setId(subjectId);
    Subject modifiedSubject = subjectRepository.save(Subject);
    return subjectMapper.toDto(modifiedSubject);
  }

  @Override
  public void remove(UUID subjectId) {
    Subject Subject = subjectRepository.getById(String.valueOf(subjectId));
    subjectRepository.delete(Subject);
  }
}
