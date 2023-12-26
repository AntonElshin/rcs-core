package ru.rcs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import ru.rcs.dto.AnswerChooseColorDTO;
import ru.rcs.entity.AnswerChooseColor;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, imports = {LocalDateTime.class})
public interface AnswerChooseColorMapper {

    @Mapping(target = "id", ignore = true)
    AnswerChooseColor fromDto(AnswerChooseColorDTO answerChooseColorDTO);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(answerChooseColor.getId()))")
    AnswerChooseColorDTO toDto(AnswerChooseColor answerChooseColor);

    List<AnswerChooseColorDTO> toListDto(List<AnswerChooseColor> answerChooseColors);

    List<AnswerChooseColor> fromListDto(List<AnswerChooseColorDTO> answerChooseColorsDTO);
}
