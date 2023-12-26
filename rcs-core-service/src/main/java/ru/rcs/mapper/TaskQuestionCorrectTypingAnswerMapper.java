package ru.rcs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import ru.rcs.dto.TaskQuestionCorrectTypingAnswerDTO;
import ru.rcs.entity.TaskQuestionCorrectTypingAnswer;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, imports = {LocalDateTime.class})
public interface TaskQuestionCorrectTypingAnswerMapper {

    @Mapping(target = "id", ignore = true)
    TaskQuestionCorrectTypingAnswer fromDto(TaskQuestionCorrectTypingAnswerDTO taskQuestionCorrectTypingAnswerDTO);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(taskQuestionCorrectTypingAnswer.getId()))")
    TaskQuestionCorrectTypingAnswerDTO toDto(TaskQuestionCorrectTypingAnswer taskQuestionCorrectTypingAnswer);

    List<TaskQuestionCorrectTypingAnswerDTO> toListDto(List<TaskQuestionCorrectTypingAnswer> taskQuestionCorrectTypingAnswers);
}
