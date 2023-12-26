package ru.rcs.service.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rcs.dto.TaskDTO;
import ru.rcs.entity.QTask;
import ru.rcs.entity.Task;
import ru.rcs.mapper.TaskMapper;
import ru.rcs.repository.TaskRepository;
import ru.rcs.service.TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    @Override
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
    public TaskDTO findById(UUID taskId) {
        return null;
    }

    @Override
    public TaskDTO add(TaskDTO taskDTO) {
        return null;
    }

    @Override
    public TaskDTO modify(UUID taskId, TaskDTO taskDTO) {
        return null;
    }

    @Override
    public void remove(UUID taskId) {

    }
}
