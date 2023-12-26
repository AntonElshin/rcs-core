package ru.rcs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import ru.rcs.dto.TaskCorrectTypingAnswerDTO;
import ru.rcs.entity.TaskCorrectTypingAnswer;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, imports = {LocalDateTime.class})
public interface TaskCorrectTypingAnswerMapper {

    @Mapping(target = "id", ignore = true)
    TaskCorrectTypingAnswer fromDto(TaskCorrectTypingAnswerDTO taskCorrectTypingAnswerDTO);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(taskCorrectTypingAnswer.getId()))")
    TaskCorrectTypingAnswerDTO toDto(TaskCorrectTypingAnswer taskCorrectTypingAnswer);

    List<TaskCorrectTypingAnswerDTO> toListDto(List<TaskCorrectTypingAnswer> taskCorrectTypingAnswers);
}
