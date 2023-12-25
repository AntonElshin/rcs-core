package ru.rcs.service;

import java.util.List;
import java.util.UUID;

import ru.rcs.dto.SchoolTestDTO;

public interface SchoolTestService {
  List<SchoolTestDTO> find(UUID searchSchoolClassId, UUID searchSubjectId);
  SchoolTestDTO findById(UUID schoolTestId);
  SchoolTestDTO add(SchoolTestDTO schoolTestReqDTO);
  SchoolTestDTO modify(UUID schoolTestId, SchoolTestDTO schoolTestReqDTO);
  void remove(UUID schoolTestId);
}
