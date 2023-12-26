package ru.rcs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;
import ru.rcs.dto.TaskDTO;
import ru.rcs.entity.Task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, imports = {LocalDateTime.class})
public interface TaskMapper {

    TaskMapper taskMapper = Mappers.getMapper(TaskMapper.class);
    TaskTypeMapper taskTypeMapper = Mappers.getMapper(TaskTypeMapper.class);
    @Mapping(target = "id", ignore = true)
    default Task fromDto(TaskDTO taskDTO) {

        if(taskDTO == null) {
            return null;
        }

        Task task = new Task();

        return task;
    }

    default TaskDTO toDto(Task task) {

        if(task == null) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setId(UUID.fromString(task.getId()));
        taskDTO.setNumber(Long.valueOf(task.getNumber()));
        taskDTO.setTaskStatement(task.getTaskStatement());
        taskDTO.setTaskHint(task.getTaskHint());
        if(task.getTaskQuestionAnswerQuantity() != null) {
            taskDTO.setTaskQuestionAnswerQuantity(Long.valueOf(task.getTaskQuestionAnswerQuantity()));
        }

        if(task.getTaskType() != null) {
            taskDTO.setTaskType(taskTypeMapper.toDto(task.getTaskType()));
        }

        return taskDTO;
    }

    List<TaskDTO> toListDto(List<Task> tasks);
}
