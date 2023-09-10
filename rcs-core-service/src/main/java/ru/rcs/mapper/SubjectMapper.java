package ru.rcs.mapper;

import java.time.LocalDateTime;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import ru.rcs.dto.SubjectDTO;
import ru.rcs.entity.Subject;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, imports = {LocalDateTime.class})
public interface SubjectMapper {

  Subject fromDto(SubjectDTO subjectDTO);

  SubjectDTO toDto(Subject subject);

  List<SubjectDTO> toListDto(List<Subject> subjects);
}
