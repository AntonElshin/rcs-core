package ru.rcs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import ru.rcs.dto.ImageDTO;
import ru.rcs.entity.Image;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, imports = {LocalDateTime.class})
public interface ImageMapper {

    @Mapping(target = "id", ignore = true)
    Image fromDto(ImageDTO imageDTO);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(image.getId()))")
    ImageDTO toDto(Image image);

    List<ImageDTO> toListDto(List<Image> images);
}
