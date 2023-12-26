package ru.rcs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;
import ru.rcs.dto.TaskQuestionDTO;
import ru.rcs.entity.TaskQuestion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, imports = {LocalDateTime.class})
public interface TaskQuestionMapper {

    TaskQuestionMapper taskQuestionMapper = Mappers.getMapper(TaskQuestionMapper.class);
    ImageMapper imageMapper = Mappers.getMapper(ImageMapper.class);
    TaskQuestionCorrectTypingAnswerMapper taskQuestionCorrectTypingAnswerMapper = Mappers.getMapper(TaskQuestionCorrectTypingAnswerMapper.class);

    default TaskQuestion fromDto(TaskQuestionDTO taskQuestionDTO) {

        if(taskQuestionDTO == null) {
            return null;
        }

        TaskQuestion taskQuestion = new TaskQuestion();

        taskQuestion.setId(String.valueOf(taskQuestionDTO.getId()));
        if(taskQuestionDTO.getNumber() != null) {
            taskQuestion.setNumber(Math.toIntExact(taskQuestionDTO.getNumber()));
        }
        taskQuestion.setText(taskQuestionDTO.getText());
        taskQuestion.setPrefilledAnswer(taskQuestionDTO.getPrefilledAnswer());

        if(taskQuestionDTO.getTaskQuestionImage() != null) {
            taskQuestion.setTaskQuestionImage(imageMapper.fromDto(taskQuestionDTO.getTaskQuestionImage()));
        }

        if(taskQuestionDTO.getTaskQuestionCorrectTypingAnswer() != null) {
            taskQuestion.setTaskQuestionCorrectTypingAnswer(taskQuestionCorrectTypingAnswerMapper.fromDto(taskQuestionDTO.getTaskQuestionCorrectTypingAnswer()));
        }

        return taskQuestion;
    }

    default TaskQuestionDTO toDto(TaskQuestion taskQuestion) {

        if(taskQuestion == null) {
            return null;
        }

        TaskQuestionDTO taskQuestionDTO = new TaskQuestionDTO();

        taskQuestionDTO.setId(UUID.fromString(taskQuestion.getId()));
        if(taskQuestion.getNumber() != null) {
            taskQuestionDTO.setNumber(Long.valueOf(taskQuestion.getNumber()));
        }
        taskQuestionDTO.setText(taskQuestion.getText());
        taskQuestionDTO.setPrefilledAnswer(taskQuestion.getPrefilledAnswer());

        if(taskQuestion.getTaskQuestionImage() != null) {
            taskQuestionDTO.setTaskQuestionImage(imageMapper.toDto(taskQuestion.getTaskQuestionImage()));
        }

        if(taskQuestion.getTaskQuestionCorrectTypingAnswer() != null) {
            taskQuestionDTO.setTaskQuestionCorrectTypingAnswer(taskQuestionCorrectTypingAnswerMapper.toDto(taskQuestion.getTaskQuestionCorrectTypingAnswer()));
        }

        return taskQuestionDTO;
    }

    List<TaskQuestionDTO> toListDto(List<TaskQuestion> taskQuestions);

    List<TaskQuestion> fromListDto(List<TaskQuestionDTO> taskQuestionsDTO);
}
