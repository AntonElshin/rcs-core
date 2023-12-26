package ru.rcs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import ru.rcs.dto.AnswerChooseTypeDTO;
import ru.rcs.entity.AnswerChooseType;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, imports = {LocalDateTime.class})
public interface AnswerChooseTypeMapper {

    @Mapping(target = "id", ignore = true)
    AnswerChooseType fromDto(AnswerChooseTypeDTO answerChooseTypeDTO);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(answerChooseType.getId()))")
    AnswerChooseTypeDTO toDto(AnswerChooseType answerChooseType);

    List<AnswerChooseTypeDTO> toListDto(List<AnswerChooseType> answerChooseTypes);
}
