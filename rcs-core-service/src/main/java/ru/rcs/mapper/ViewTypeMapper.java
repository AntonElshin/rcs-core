package ru.rcs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import ru.rcs.dto.ViewTypeDTO;
import ru.rcs.entity.ViewType;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, imports = {LocalDateTime.class})
public interface ViewTypeMapper {

    @Mapping(target = "id", ignore = true)
    ViewType fromDto(ViewTypeDTO viewTypeDTO);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(viewType.getId()))")
    ViewTypeDTO toDto(ViewType viewType);

    List<ViewTypeDTO> toListDto(List<ViewType> viewTypes);
}
