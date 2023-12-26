package ru.rcs.mapper;

import java.time.LocalDateTime;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import ru.rcs.dto.SchoolTestDTO;
import ru.rcs.entity.SchoolTest;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, imports = {LocalDateTime.class})
public interface SchoolTestMapper {

  @Mapping(target = "id", expression = "java(java.lang.String.valueOf(schoolTestDTO.getId()))")
  @Mapping(target = "schoolClass.id", expression = "java(java.lang.String.valueOf(schoolClassDTO.getId()))")
  @Mapping(target = "subject.id", expression = "java(java.lang.String.valueOf(subjectDTO.getId()))")
  SchoolTest fromDto(SchoolTestDTO schoolTestDTO);

  @Mapping(target = "id", expression = "java(java.util.UUID.fromString(schoolTest.getId()))")
  @Mapping(target = "schoolClass.id", expression = "java(java.util.UUID.fromString(schoolClass.getId()))")
  @Mapping(target = "subject.id", expression = "java(java.util.UUID.fromString(subject.getId()))")
  SchoolTestDTO toDto(SchoolTest schoolTest);

  List<SchoolTestDTO> toListDto(List<SchoolTest> schoolTests);
}
