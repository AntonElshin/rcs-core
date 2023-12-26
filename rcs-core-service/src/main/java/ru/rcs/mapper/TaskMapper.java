package ru.rcs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;
import ru.rcs.dto.TaskDTO;
import ru.rcs.entity.Task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, imports = {LocalDateTime.class})
public interface TaskMapper {

    SchoolTestMapper schoolTestMapper = Mappers.getMapper(SchoolTestMapper.class);
    TaskTypeMapper taskTypeMapper = Mappers.getMapper(TaskTypeMapper.class);
    ImageMapper imageMapper = Mappers.getMapper(ImageMapper.class);
    TaskTextMapper taskTextMapper = Mappers.getMapper(TaskTextMapper.class);
    AnswerPositionMapper answerPositionMapper = Mappers.getMapper(AnswerPositionMapper.class);
    AnswerTypingFormatMapper answerTypingFormatMapper = Mappers.getMapper(AnswerTypingFormatMapper.class);
    AnswerChooseTypeMapper answerChooseTypeMapper = Mappers.getMapper(AnswerChooseTypeMapper.class);
    AnswerChooseColorMapper answerChooseColorMapper = Mappers.getMapper(AnswerChooseColorMapper.class);
    ViewTypeMapper viewTypeMapper = Mappers.getMapper(ViewTypeMapper.class);
    TaskCorrectTypingAnswerMapper taskCorrectTypingAnswerMapper = Mappers.getMapper(TaskCorrectTypingAnswerMapper.class);
    TaskQuestionMapper taskQuestionMapper = Mappers.getMapper(TaskQuestionMapper.class);
    TaskProposedAnswerMapper taskProposedAnswerMapper = Mappers.getMapper(TaskProposedAnswerMapper.class);

    default Task fromDto(TaskDTO taskDTO) {

        if(taskDTO == null) {
            return null;
        }

        Task task = new Task();

        task.setId(String.valueOf(taskDTO.getId()));

        if(taskDTO.getSchoolTest() != null) {
            task.setSchoolTest(schoolTestMapper.fromDto(taskDTO.getSchoolTest()));
        }

        task.setNumber(Math.toIntExact(taskDTO.getNumber()));
        task.setTaskStatement(taskDTO.getTaskStatement());
        task.setTaskHint(taskDTO.getTaskHint());

        if(taskDTO.getTaskQuestionAnswerQuantity() != null) {
            task.setTaskQuestionAnswerQuantity(Math.toIntExact(taskDTO.getTaskQuestionAnswerQuantity()));
        }

        if(taskDTO.getTaskType() != null) {
            task.setTaskType(taskTypeMapper.fromDto(taskDTO.getTaskType()));
        }

        if(taskDTO.getTaskImage() != null) {
            task.setTaskImage(imageMapper.fromDto(taskDTO.getTaskImage()));
        }

        if(taskDTO.getTaskText() != null) {
            task.setTaskText(taskTextMapper.fromDto(taskDTO.getTaskText()));
        }

        if(taskDTO.getTaskAnswerPosition() != null) {
            task.setTaskAnswerPosition(answerPositionMapper.fromDto(taskDTO.getTaskAnswerPosition()));
        }

        if(taskDTO.getTaskAnswerTypingFormat() != null) {
            task.setTaskAnswerTypingFormat(answerTypingFormatMapper.fromDto(taskDTO.getTaskAnswerTypingFormat()));
        }

        if(taskDTO.getTaskAnswerChooseType() != null) {
            task.setTaskAnswerChooseType(answerChooseTypeMapper.fromDto(taskDTO.getTaskAnswerChooseType()));
        }

        if(taskDTO.getTaskAnswerChooseColors() != null) {
            task.setTaskAnswerChooseColors(answerChooseColorMapper.fromListDto(taskDTO.getTaskAnswerChooseColors()));
        }

        if(taskDTO.getTaskViewType() != null) {
            task.setViewType(viewTypeMapper.fromDto(taskDTO.getTaskViewType()));
        }

        if(taskDTO.getTaskCorrectTypingAnswer() != null) {
            task.setTaskCorrectTypingAnswer(taskCorrectTypingAnswerMapper.fromDto(taskDTO.getTaskCorrectTypingAnswer()));
        }

        if(taskDTO.getTaskQuestions() != null) {
            task.setTaskQuestions(taskQuestionMapper.fromListDto(taskDTO.getTaskQuestions()));
        }

        if(taskDTO.getTaskProposedAnswers() != null) {
            task.setTaskProposedAnswers(taskProposedAnswerMapper.fromListDto(taskDTO.getTaskProposedAnswers()));
        }

        return task;
    }

    default TaskDTO toDto(Task task) {

        if(task == null) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setId(UUID.fromString(task.getId()));

        if(task.getSchoolTest() != null) {
            taskDTO.setSchoolTest(schoolTestMapper.toDto(task.getSchoolTest()));
        }

        taskDTO.setNumber(Long.valueOf(task.getNumber()));
        taskDTO.setTaskStatement(task.getTaskStatement());
        taskDTO.setTaskHint(task.getTaskHint());

        if(task.getTaskQuestionAnswerQuantity() != null) {
            taskDTO.setTaskQuestionAnswerQuantity(Long.valueOf(task.getTaskQuestionAnswerQuantity()));
        }

        if(task.getTaskType() != null) {
            taskDTO.setTaskType(taskTypeMapper.toDto(task.getTaskType()));
        }

        if(task.getTaskImage() != null) {
            taskDTO.setTaskImage(imageMapper.toDto(task.getTaskImage()));
        }

        if(task.getTaskText() != null) {
            taskDTO.setTaskText(taskTextMapper.toDto(task.getTaskText()));
        }

        if(task.getTaskAnswerPosition() != null) {
            taskDTO.setTaskAnswerPosition(answerPositionMapper.toDto(task.getTaskAnswerPosition()));
        }

        if(task.getTaskAnswerTypingFormat() != null) {
            taskDTO.setTaskAnswerTypingFormat(answerTypingFormatMapper.toDto(task.getTaskAnswerTypingFormat()));
        }

        if(task.getTaskAnswerChooseType() != null) {
            taskDTO.setTaskAnswerChooseType(answerChooseTypeMapper.toDto(task.getTaskAnswerChooseType()));
        }

        if(task.getTaskAnswerChooseColors() != null) {
            taskDTO.setTaskAnswerChooseColors(answerChooseColorMapper.toListDto(task.getTaskAnswerChooseColors()));
        }

        if(task.getViewType() != null) {
            taskDTO.setTaskViewType(viewTypeMapper.toDto(task.getViewType()));
        }

        if(task.getTaskCorrectTypingAnswer() != null) {
            taskDTO.setTaskCorrectTypingAnswer(taskCorrectTypingAnswerMapper.toDto(task.getTaskCorrectTypingAnswer()));
        }

        if(task.getTaskQuestions() != null) {
            taskDTO.setTaskQuestions(taskQuestionMapper.toListDto(task.getTaskQuestions()));
        }

        if(task.getTaskProposedAnswers() != null) {
            taskDTO.setTaskProposedAnswers(taskProposedAnswerMapper.toListDto(task.getTaskProposedAnswers()));
        }

        return taskDTO;
    }

    List<TaskDTO> toListDto(List<Task> tasks);
}
