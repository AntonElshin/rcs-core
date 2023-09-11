package ru.rcs.web;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.rcs.api.SchoolTestsApi;
import ru.rcs.dto.SchoolTestResDTO;

@RestController
@RequiredArgsConstructor
public class TestsController implements SchoolTestsApi {


  @Override
  public ResponseEntity<List<SchoolTestResDTO>> findSchoolTests(UUID schoolTestClassId,
      UUID schoolTestSubjectId) {
    return null;
  }
}
