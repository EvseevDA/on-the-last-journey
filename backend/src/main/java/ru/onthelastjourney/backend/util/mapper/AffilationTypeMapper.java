package ru.onthelastjourney.backend.util.mapper;

import ru.onthelastjourney.backend.dto.AffilationTypeDto;
import ru.onthelastjourney.backend.entity.AffilationType;

import java.util.List;

public class AffilationTypeMapper {

    public static AffilationTypeDto toDto(AffilationType affilationType) {
        return new AffilationTypeDto(
                affilationType.getCategory(),
                affilationType.getDescription()
        );
    }

    public static List<AffilationTypeDto> toDto(List<AffilationType> types) {
        return types.stream()
                .map(AffilationTypeMapper::toDto)
                .toList();
    }

    public static AffilationType fromDto(AffilationTypeDto dto) {
        return AffilationType.builder()
                .category(dto.getCategory())
                .description(dto.getDescription())
                .build();
    }

    public static List<AffilationType> fromDto(List<AffilationTypeDto> dtos) {
        return dtos.stream()
                .map(AffilationTypeMapper::fromDto)
                .toList();
    }

}
