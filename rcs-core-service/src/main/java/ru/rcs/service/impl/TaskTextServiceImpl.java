package ru.rcs.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.rcs.dto.TaskTextDTO;
import ru.rcs.entity.TaskText;
import ru.rcs.mapper.TaskTextMapper;
import ru.rcs.repository.TaskTextRepository;
import ru.rcs.service.TaskTextService;

@Service
@RequiredArgsConstructor
public class TaskTextServiceImpl implements TaskTextService {

    private final TaskTextRepository taskTextRepository;

    private final TaskTextMapper taskTextMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public TaskText add(TaskTextDTO taskTextDTO) {
        return taskTextRepository.save(taskTextMapper.fromDto(taskTextDTO));
    }
}
