package ru.rcs.web;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.rcs.api.SubjectApi;
import ru.rcs.dto.SubjectDTO;
import ru.rcs.service.SubjectService;

@RestController
@RequiredArgsConstructor
public class SubjectController implements SubjectApi {

  private final SubjectService subjectService;

  @Override
  public ResponseEntity<List<SubjectDTO>> findSubjects(String search) {
    return ResponseEntity.ok(subjectService.find(search));
  }

  @Override
  public ResponseEntity<SubjectDTO> findSubjectById(UUID subjectId) {
    return ResponseEntity.ok(subjectService.findById(subjectId));
  }

  @Override
  public ResponseEntity<SubjectDTO> modifySubject(UUID subjectId, SubjectDTO subjectDTO) {
    return ResponseEntity.ok(subjectService.modify(subjectId, subjectDTO));
  }

  @Override
  public ResponseEntity<Void> removeSubject(UUID subjectId) {
    subjectService.remove(subjectId);
    return ResponseEntity.ok(null);
  }

  @Override
  public ResponseEntity<SubjectDTO> addSubject(SubjectDTO subjectDTO) {
    return ResponseEntity.ok(subjectService.add(subjectDTO));
  }
}
