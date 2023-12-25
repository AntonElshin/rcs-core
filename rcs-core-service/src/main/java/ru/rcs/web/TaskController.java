package ru.rcs.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.rcs.api.TaskApi;
import ru.rcs.dto.TaskDTO;
import ru.rcs.service.TaskService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TaskController implements TaskApi {

    private final TaskService taskService;

    @Override
    public ResponseEntity<TaskDTO> addTask(TaskDTO taskDTO) {
        return null;
    }

    @Override
    public ResponseEntity<TaskDTO> findTaskById(UUID taskId) {
        return null;
    }

    @Override
    public ResponseEntity<List<TaskDTO>> findTasks(UUID searchSchoolTestId) {

        taskService.find(searchSchoolTestId);
        return null;
    }

    @Override
    public ResponseEntity<TaskDTO> modifyTask(UUID taskId, TaskDTO taskDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Void> removeTask(UUID taskId) {
        return null;
    }
}
