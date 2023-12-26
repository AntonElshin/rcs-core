package ru.rcs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import ru.rcs.dto.AnswerTypingFormatDTO;
import ru.rcs.entity.AnswerTypingFormat;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, imports = {LocalDateTime.class})
public interface AnswerTypingFormatMapper {

    @Mapping(target = "id", ignore = true)
    AnswerTypingFormat fromDto(AnswerTypingFormatDTO answerTypingFormatDTO);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(answerTypingFormat.getId()))")
    AnswerTypingFormatDTO toDto(AnswerTypingFormat answerTypingFormat);

    List<AnswerTypingFormatDTO> toListDto(List<AnswerTypingFormat> answerTypingFormats);
}
