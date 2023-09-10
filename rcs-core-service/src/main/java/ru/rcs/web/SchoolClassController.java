package ru.rcs.web;

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
  public ResponseEntity<SchoolClassDTO> getSchoolClassById(UUID schoolClassId) {
    return ResponseEntity.ok(schoolClassService.getById(schoolClassId));
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
