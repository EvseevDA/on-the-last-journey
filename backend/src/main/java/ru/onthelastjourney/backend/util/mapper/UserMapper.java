package ru.onthelastjourney.backend.util.mapper;

import ru.onthelastjourney.backend.dto.UserDto;
import ru.onthelastjourney.backend.entity.User;

import java.util.List;

public class UserMapper {

    public static UserDto toDto(User user) {
        return new UserDto(
                user.getLogin(),
                user.getPassword(),
                user.getRoles()
        );
    }

    public static List<UserDto> toDto(List<User> users) {
        return users.stream()
                .map(UserMapper::toDto)
                .toList();
    }

    public static User fromDto(UserDto dto) {
        return User.builder()
                .login(dto.getLogin())
                .password(dto.getPassword())
                .roles(dto.getRoles())
                .build();
    }

    public static List<User> fromDto(List<UserDto> dtos) {
        return dtos.stream()
                .map(UserMapper::fromDto)
                .toList();
    }

}
