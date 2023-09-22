package ru.rcs.service;

import java.util.List;
import java.util.UUID;
import ru.rcs.dto.SubjectDTO;

public interface SubjectService {
  List<SubjectDTO> find(String search);
  SubjectDTO findById(UUID schoolClassId);
  SubjectDTO add(SubjectDTO subjectDTO);
  SubjectDTO modify(UUID subjectId, SubjectDTO subjectDTO);
  void remove(UUID schoolClassId);
}
