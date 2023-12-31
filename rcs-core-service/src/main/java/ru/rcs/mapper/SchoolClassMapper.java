package ru.rcs.mapper;

import java.time.LocalDateTime;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import ru.rcs.dto.SchoolClassDTO;
import ru.rcs.entity.SchoolClass;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, imports = {LocalDateTime.class})
public interface SchoolClassMapper {

  @Mapping(target = "id", ignore = true)
  SchoolClass fromDto(SchoolClassDTO schoolClassDTO);

  @Mapping(target = "id", expression = "java(java.util.UUID.fromString(schoolClass.getId()))")
  SchoolClassDTO toDto(SchoolClass schoolClass);

  List<SchoolClassDTO> toListDto(List<SchoolClass> schoolClasses);
}
