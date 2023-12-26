package ru.rcs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;
import ru.rcs.dto.TaskProposedAnswerDTO;
import ru.rcs.entity.TaskProposedAnswer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, imports = {LocalDateTime.class})
public interface TaskProposedAnswerMapper {

    TaskProposedAnswerMapper taskProposedAnswerMapper = Mappers.getMapper(TaskProposedAnswerMapper.class);
    ImageMapper imageMapper = Mappers.getMapper(ImageMapper.class);
    AnswerChooseColorMapper answerChooseColorMapper = Mappers.getMapper(AnswerChooseColorMapper.class);

    default TaskProposedAnswer fromDto(TaskProposedAnswerDTO taskProposedAnswerDTO) {

        if(taskProposedAnswerDTO == null) {
            return null;
        }

        TaskProposedAnswer taskProposedAnswer = new TaskProposedAnswer();

        taskProposedAnswer.setId(String.valueOf(taskProposedAnswerDTO.getId()));
        taskProposedAnswer.setProposedAnswer(taskProposedAnswerDTO.getProposedAnswer());
        taskProposedAnswer.setIsCorrect(taskProposedAnswerDTO.getIsCorrect());

        if(taskProposedAnswerDTO.getCorrectAnswerChooseColor() != null) {
            taskProposedAnswer.setAnswerChooseColor(answerChooseColorMapper.fromDto(taskProposedAnswerDTO.getCorrectAnswerChooseColor()));
        }

        if(taskProposedAnswerDTO.getTaskProposedAnswerImage() != null) {
            taskProposedAnswer.setTaskImage(imageMapper.fromDto(taskProposedAnswerDTO.getTaskProposedAnswerImage()));
        }

        return taskProposedAnswer;
    }

    default TaskProposedAnswerDTO toDto(TaskProposedAnswer taskProposedAnswer) {

        if(taskProposedAnswer == null) {
            return null;
        }

        TaskProposedAnswerDTO taskProposedAnswerDTO = new TaskProposedAnswerDTO();

        taskProposedAnswerDTO.setId(UUID.fromString(taskProposedAnswer.getId()));
        taskProposedAnswerDTO.setProposedAnswer(taskProposedAnswer.getProposedAnswer());
        taskProposedAnswerDTO.setIsCorrect(taskProposedAnswer.getIsCorrect());

        if(taskProposedAnswer.getAnswerChooseColor() != null) {
            taskProposedAnswerDTO.setCorrectAnswerChooseColor(answerChooseColorMapper.toDto(taskProposedAnswer.getAnswerChooseColor()));
        }

        if(taskProposedAnswer.getTaskImage() != null) {
            taskProposedAnswerDTO.setTaskProposedAnswerImage(imageMapper.toDto(taskProposedAnswer.getTaskImage()));
        }

        return taskProposedAnswerDTO;
    }

    List<TaskProposedAnswerDTO> toListDto(List<TaskProposedAnswer> taskProposedAnswers);
}
