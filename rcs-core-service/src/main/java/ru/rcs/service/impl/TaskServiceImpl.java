package ru.rcs.service.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rcs.dto.TaskDTO;
import ru.rcs.entity.QTask;
import ru.rcs.entity.Task;
import ru.rcs.exception.BusinessException;
import ru.rcs.exception.Errors;
import ru.rcs.mapper.TaskMapper;
import ru.rcs.repository.TaskRepository;
import ru.rcs.service.TaskService;
import ru.rcs.service.SchoolTestTextService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final SchoolTestTextService schoolTestTextService;

    @Override
    @Transactional(readOnly = true)
    public List<TaskDTO> find(UUID searchSchoolTestId) {

        List<BooleanExpression> predicates = new ArrayList<>();

        if(searchSchoolTestId != null) {
            predicates.add(QTask.task.schoolTest.id.eq(String.valueOf(searchSchoolTestId)));
        }

        List<Task> tasks;

        if(predicates.size() == 0) {
            tasks = taskRepository.findAll();
        }
        else if(predicates.size() == 1) {
            tasks = taskRepository.findAll(predicates.get(0));
        }
        else {
            BooleanExpression fullPredicate = predicates.get(0);
            int index = 0;
            for(BooleanExpression predicate : predicates) {
                if(index < predicates.size() - 1) {
                    index++;
                    fullPredicate = fullPredicate.and(predicates.get(index));
                }
            }
            tasks = taskRepository.findAll(fullPredicate);
        }

        return taskMapper.toListDto(tasks);
    }

    @Override
    @Transactional(readOnly = true)
    public TaskDTO findById(UUID taskId) {
        Task task = taskRepository.findById(String.valueOf(taskId))
                .orElseThrow(() -> new BusinessException(Errors.SUBJECT_NOT_FOUND_BY_ID, taskId));
        return taskMapper.toDto(task);
    }

    @Override
    @Transactional
    public TaskDTO add(TaskDTO taskDTO) {
        Task task = taskMapper.fromDto(taskDTO);
        Task addedTask = taskRepository.save(task);
        return taskMapper.toDto(addedTask);
    }

    @Override
    @Transactional
    public TaskDTO modify(UUID taskId, TaskDTO taskDTO) {
        Task foundTask = taskRepository.getById(String.valueOf(taskId));
        Task modifiedTask = taskRepository.save(foundTask);
        return taskMapper.toDto(modifiedTask);
    }

    @Override
    public void remove(UUID taskId) {

        Task task = taskRepository.findById(String.valueOf(taskId))
                .orElseThrow(() -> new BusinessException(Errors.TASK_NOT_FOUND_BY_ID, taskId));

        taskRepository.delete(task);
    }
}
