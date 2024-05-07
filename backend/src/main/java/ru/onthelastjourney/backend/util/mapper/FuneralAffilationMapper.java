package ru.onthelastjourney.backend.util.mapper;

import ru.onthelastjourney.backend.dto.FuneralAffilationDto;
import ru.onthelastjourney.backend.entity.FuneralAffilation;

import java.util.List;

public class FuneralAffilationMapper {

    public static FuneralAffilationDto toDto(FuneralAffilation funeralAffilation) {
        return new FuneralAffilationDto(
                funeralAffilation.getProvider(),
                funeralAffilation.getAffilationType(),
                funeralAffilation.getUnit(),
                funeralAffilation.getPrice(),
                funeralAffilation.getInStorage(),
                funeralAffilation.getExpected(),
                funeralAffilation.getSuppliesStopped(),
                funeralAffilation.getPhotoUrl(),
                funeralAffilation.getName(),
                funeralAffilation.getDescription()
        );
    }

    public static List<FuneralAffilationDto>
    toDto(List<FuneralAffilation> funeralAffilations) {
        return funeralAffilations.stream()
                .map(FuneralAffilationMapper::toDto)
                .toList();
    }

    public static FuneralAffilation fromDto(FuneralAffilationDto dto) {
        return FuneralAffilation.builder()
                .provider(dto.getProvider())
                .affilationType(dto.getAffilationType())
                .unit(dto.getUnit())
                .price(dto.getPrice())
                .inStorage(dto.getInStorage())
                .expected(dto.getExpected())
                .suppliesStopped(dto.getSuppliesStopped())
                .photoUrl(dto.getPhotoUrl())
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }

    public static List<FuneralAffilation>
    fromDto(List<FuneralAffilationDto> dtos) {
        return dtos.stream()
                .map(FuneralAffilationMapper::fromDto)
                .toList();
    }

}
