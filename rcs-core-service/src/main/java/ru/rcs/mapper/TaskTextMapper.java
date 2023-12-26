package ru.rcs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import ru.rcs.dto.TaskTextDTO;
import ru.rcs.entity.TaskText;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, imports = {LocalDateTime.class})
public interface TaskTextMapper {

    @Mapping(target = "id", expression = "java(java.lang.String.valueOf(taskTextDTO.getId()))")
    TaskText fromDto(TaskTextDTO taskTextDTO);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(taskText.getId()))")
    TaskTextDTO toDto(TaskText taskText);

    List<TaskTextDTO> toListDto(List<TaskText> taskTexts);
}
