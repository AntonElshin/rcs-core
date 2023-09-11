package ru.rcs.mapper;

import java.time.LocalDateTime;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import ru.rcs.dto.SchoolTestResDTO;
import ru.rcs.entity.SchoolTest;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, imports = {LocalDateTime.class})
public interface SchoolTestMapper {

  @Mapping(target = "id", expression = "java(java.util.UUID.fromString(schoolTest.getId()))")
  @Mapping(target = "schoolClass.id", expression = "java(java.util.UUID.fromString(schoolClass.getId()))")
  @Mapping(target = "subject.id", expression = "java(java.util.UUID.fromString(subject.getId()))")
  SchoolTestResDTO toDto(SchoolTest schoolTest);

  List<SchoolTestResDTO> toListDto(List<SchoolTest> schoolTests);
}
