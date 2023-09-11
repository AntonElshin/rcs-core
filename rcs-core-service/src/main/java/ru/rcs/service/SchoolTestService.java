package ru.rcs.service;

import java.util.List;
import java.util.UUID;
import ru.rcs.dto.SchoolTestReqDTO;
import ru.rcs.dto.SchoolTestResDTO;

public interface SchoolTestService {
  List<SchoolTestReqDTO> find(String search);
  SchoolTestResDTO getById(UUID schoolTestId);
  SchoolTestResDTO add(SchoolTestReqDTO schoolTestReqDTO);
  SchoolTestResDTO modify(UUID schoolTestId, SchoolTestReqDTO schoolTestReqDTO);
  void remove(UUID schoolTestId);
}
