package ru.rcs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import ru.rcs.dto.SchoolTestTextDTO;
import ru.rcs.entity.SchoolTestText;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, imports = {LocalDateTime.class})
public interface SchoolTestTextMapper {

    @Mapping(target = "id", expression = "java(java.lang.String.valueOf(schoolTestTextDTO.getId()))")
    SchoolTestText fromDto(SchoolTestTextDTO schoolTestTextDTO);

    @Mapping(target = "id", ignore = true)
    SchoolTestTextDTO toDto(SchoolTestText schoolTestText);

    List<SchoolTestTextDTO> toListDto(List<SchoolTestText> schoolTestTexts);
}
