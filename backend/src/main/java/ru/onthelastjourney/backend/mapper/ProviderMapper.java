package ru.onthelastjourney.backend.mapper;

import ru.onthelastjourney.backend.dto.ProviderDto;
import ru.onthelastjourney.backend.entity.Provider;

import java.util.List;

public class ProviderMapper {

    public static ProviderDto toDto(Provider provider) {
        return new ProviderDto(
                provider.getName(),
                provider.getSpeakTo(),
                provider.getJobTitle(),
                provider.getCountry(),
                provider.getRegion(),
                provider.getCity(),
                provider.getIndex(),
                provider.getPhoneNumber()
        );
    }

    public static List<ProviderDto> toDto(List<Provider> providers) {
        return providers.stream()
                .map(ProviderMapper::toDto)
                .toList();
    }

    public static Provider fromDto(ProviderDto dto) {
        return Provider.builder()
                .name(dto.getName())
                .speakTo(dto.getSpeakTo())
                .jobTitle(dto.getJobTitle())
                .country(dto.getCountry())
                .region(dto.getRegion())
                .city(dto.getCity())
                .index(dto.getIndex())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }

    public static List<Provider> fromDto(List<ProviderDto> dtos) {
        return dtos.stream()
                .map(ProviderMapper::fromDto)
                .toList();
    }
}
