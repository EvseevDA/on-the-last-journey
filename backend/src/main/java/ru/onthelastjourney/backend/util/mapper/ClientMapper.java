package ru.onthelastjourney.backend.util.mapper;

import ru.onthelastjourney.backend.dto.ClientDto;
import ru.onthelastjourney.backend.entity.Client;

import java.util.List;

public class ClientMapper {

    public static ClientDto toDto(Client client) {
        return new ClientDto(client.getSurname(),
                client.getName(),
                client.getPatronymic(),
                client.getCountry(),
                client.getRegion(),
                client.getCity(),
                client.getPhoneNumber(),
                client.getIndex());
    }

    public static List<ClientDto> toDto(List<Client> clients) {
        return clients.stream()
                .map(ClientMapper::toDto)
                .toList();
    }

    public static Client fromDto(ClientDto dto) {
        return Client.builder()
                .surname(dto.getSurname())
                .name(dto.getName())
                .patronymic(dto.getPatronymic())
                .country(dto.getCountry())
                .region(dto.getRegion())
                .city(dto.getCity())
                .phoneNumber(dto.getPhoneNumber())
                .index(dto.getIndex())
                .build();
    }

    public static List<Client> fromDto(List<ClientDto> dtos) {
        return dtos.stream()
                .map(ClientMapper::fromDto)
                .toList();
    }
}
