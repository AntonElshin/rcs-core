package ru.rcs.service;

import ru.rcs.dto.TaskTextDTO;
import ru.rcs.entity.TaskText;

public interface TaskTextService {

    TaskText add(TaskTextDTO taskTextDTO);

}
