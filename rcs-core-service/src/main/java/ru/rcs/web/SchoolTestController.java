package ru.rcs.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.rcs.api.SchoolTestApi;
import ru.rcs.dto.SchoolTestDTO;
import ru.rcs.service.SchoolTestService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class SchoolTestController implements SchoolTestApi {

    private final SchoolTestService schoolTestService;

    @Override
    public ResponseEntity<List<SchoolTestDTO>> findSchoolTests(UUID searchSchoolClassId, UUID searchSubjectId) {
        return ResponseEntity.ok(schoolTestService.find(searchSchoolClassId, searchSubjectId));
    }

    @Override
    public ResponseEntity<SchoolTestDTO> addSchoolTest(SchoolTestDTO schoolTestDTO) {
        return ResponseEntity.ok(schoolTestService.add(schoolTestDTO));
    }

    @Override
    public ResponseEntity<SchoolTestDTO> findSchoolTestById(UUID schoolTestId) {
        return ResponseEntity.ok(schoolTestService.findById(schoolTestId));
    }

    @Override
    public ResponseEntity<SchoolTestDTO> modifySchoolTest(UUID schoolTestId, SchoolTestDTO schoolTestDTO) {
        return ResponseEntity.ok(schoolTestService.modify(schoolTestId, schoolTestDTO));
    }

    @Override
    public ResponseEntity<Void> removeSchoolTest(UUID schoolTestId) {
        schoolTestService.remove(schoolTestId);
        return ResponseEntity.ok(null);
    }
}
