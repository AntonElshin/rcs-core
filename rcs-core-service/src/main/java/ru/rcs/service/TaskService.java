package ru.rcs.service;

import ru.rcs.dto.TaskDTO;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    List<TaskDTO> find(UUID searchSchoolTestId);
    TaskDTO findById(UUID taskId);
    TaskDTO add(TaskDTO taskDTO);
    TaskDTO modify(UUID taskId, TaskDTO taskDTO);
    void remove(UUID taskId);

}
