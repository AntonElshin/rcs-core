package ru.rcs.mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;
import ru.rcs.dto.SchoolTestDTO;
import ru.rcs.entity.SchoolTest;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, imports = {LocalDateTime.class})
public interface SchoolTestMapper {

  SchoolClassMapper schoolClassMapper = Mappers.getMapper(SchoolClassMapper.class);
  SubjectMapper subjectMapper = Mappers.getMapper(SubjectMapper.class);
  SchoolTestTextMapper schoolTestTextMapper = Mappers.getMapper(SchoolTestTextMapper.class);

  @Mapping(target = "id", expression = "java(java.lang.String.valueOf(schoolTestDTO.getId()))")
  @Mapping(target = "schoolClass.id", expression = "java(java.lang.String.valueOf(schoolClassDTO.getId()))")
  @Mapping(target = "subject.id", expression = "java(java.lang.String.valueOf(subjectDTO.getId()))")
  @Mapping(target = "schoolTestText.id", expression = "java(java.lang.String.valueOf(schoolTestTextDTO.getId()))")
  SchoolTest fromDto(SchoolTestDTO schoolTestDTO);

  @Mapping(target = "id", expression = "java(java.util.UUID.fromString(schoolTest.getId()))")
  @Mapping(target = "schoolClass.id", expression = "java(java.util.UUID.fromString(schoolClass.getId()))")
  @Mapping(target = "subject.id", expression = "java(java.util.UUID.fromString(subject.getId()))")
  @Mapping(target = "schoolTestText.id", expression = "java(java.util.UUID.fromString(schoolTestText.getId()))")
  SchoolTestDTO toDto(SchoolTest schoolTest);

  List<SchoolTestDTO> toListDto(List<SchoolTest> schoolTests);
}
