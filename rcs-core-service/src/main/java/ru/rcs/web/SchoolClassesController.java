package ru.rcs.web;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.rcs.api.SchoolClassesApi;
import ru.rcs.dto.SchoolClassDTO;
import ru.rcs.service.SchoolClassService;

@RestController
@RequiredArgsConstructor
public class SchoolClassesController implements SchoolClassesApi {

  private final SchoolClassService schoolClassService;

  @Override
  public ResponseEntity<List<SchoolClassDTO>> find(String search) {
    return null;
  }
}
