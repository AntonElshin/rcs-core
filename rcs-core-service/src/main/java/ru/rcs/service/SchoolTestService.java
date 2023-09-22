package ru.rcs.service;

import java.util.List;
import java.util.UUID;
import ru.rcs.dto.SchoolTestReqDTO;
import ru.rcs.dto.SchoolTestResDTO;

public interface SchoolTestService {
  List<SchoolTestResDTO> find(UUID schoolTestClassId, UUID schoolTestSubjectId);
  SchoolTestResDTO findById(UUID schoolTestId);
  SchoolTestResDTO add(SchoolTestReqDTO schoolTestReqDTO);
  SchoolTestResDTO modify(UUID schoolTestId, SchoolTestReqDTO schoolTestReqDTO);
  void remove(UUID schoolTestId);
}
