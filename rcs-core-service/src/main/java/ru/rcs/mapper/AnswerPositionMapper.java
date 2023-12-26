package ru.rcs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import ru.rcs.dto.AnswerPositionDTO;
import ru.rcs.entity.AnswerPosition;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, imports = {LocalDateTime.class})
public interface AnswerPositionMapper {

    @Mapping(target = "id", ignore = true)
    AnswerPosition fromDto(AnswerPositionDTO answerPositionDTO);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(answerPosition.getId()))")
    AnswerPositionDTO toDto(AnswerPosition answerPosition);

    List<AnswerPositionDTO> toListDto(List<AnswerPosition> answerPositions);
}
