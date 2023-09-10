package ru.rcs.web;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.rcs.api.SubjectsApi;
import ru.rcs.dto.SubjectDTO;
import ru.rcs.service.SubjectService;

@RestController
@RequiredArgsConstructor
public class SubjectsController implements SubjectsApi {

  private final SubjectService subjectService;

  @Override
  public ResponseEntity<List<SubjectDTO>> findSubjects(String search) {
    return ResponseEntity.ok(subjectService.find(search));
  }
}
