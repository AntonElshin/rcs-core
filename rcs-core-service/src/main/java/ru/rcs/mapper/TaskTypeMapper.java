package ru.rcs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import ru.rcs.dto.TaskTypeDTO;
import ru.rcs.entity.TaskType;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, imports = {LocalDateTime.class})
public interface TaskTypeMapper {

    @Mapping(target = "id", ignore = true)
    TaskType fromDto(TaskTypeDTO taskTypeDTO);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(taskType.getId()))")
    TaskTypeDTO toDto(TaskType taskType);

    List<TaskTypeDTO> toListDto(List<TaskType> taskTypes);
}
