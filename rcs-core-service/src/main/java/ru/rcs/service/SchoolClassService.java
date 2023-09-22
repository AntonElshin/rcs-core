package ru.rcs.service;

import java.util.List;
import java.util.UUID;
import ru.rcs.dto.SchoolClassDTO;

public interface SchoolClassService {
  List<SchoolClassDTO> find(String search);
  SchoolClassDTO findById(UUID schoolClassId);
  SchoolClassDTO add(SchoolClassDTO schoolClassDTO);
  SchoolClassDTO modify(UUID schoolClassId, SchoolClassDTO schoolClassDTO);
  void remove(UUID schoolClassId);
}
