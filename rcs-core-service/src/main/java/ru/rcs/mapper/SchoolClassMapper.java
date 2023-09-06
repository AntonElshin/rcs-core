package ru.rcs.mapper;

import java.time.LocalDateTime;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import ru.rcs.dto.SchoolClassDTO;
import ru.rcs.entity.SchoolClass;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, imports = {LocalDateTime.class})
public interface SchoolClassMapper {

  SchoolClass fromDto(SchoolClassDTO schoolClassDTO);

  SchoolClassDTO toDto(SchoolClass schoolClass);

  List<SchoolClassDTO> toListDto(List<SchoolClass> schoolClasses);
}
