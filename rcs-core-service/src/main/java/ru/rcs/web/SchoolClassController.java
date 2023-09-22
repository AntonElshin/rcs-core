package ru.rcs.web;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.rcs.api.SchoolClassApi;
import ru.rcs.dto.SchoolClassDTO;
import ru.rcs.service.SchoolClassService;

@RestController
@RequiredArgsConstructor
public class SchoolClassController implements SchoolClassApi {

  private final SchoolClassService schoolClassService;

  @Override
  public ResponseEntity<List<SchoolClassDTO>> findSchoolClasses(String search) {
    return ResponseEntity.ok(schoolClassService.find(search));
  }

  @Override
  public ResponseEntity<SchoolClassDTO> findSchoolClassById(UUID schoolClassId) {
    return ResponseEntity.ok(schoolClassService.findById(schoolClassId));
  }

  @Override
  public ResponseEntity<SchoolClassDTO> modifySchoolClass(UUID schoolClassId,
      SchoolClassDTO schoolClassDTO) {
    return ResponseEntity.ok(schoolClassService.modify(schoolClassId, schoolClassDTO));
  }

  @Override
  public ResponseEntity<Void> removeSchoolClass(UUID schoolClassId) {
    schoolClassService.remove(schoolClassId);
    return ResponseEntity.ok(null);
  }

  @Override
  public ResponseEntity<SchoolClassDTO> addSchoolClass(SchoolClassDTO schoolClassDTO) {
    return ResponseEntity.ok(schoolClassService.add(schoolClassDTO));
  }
}
