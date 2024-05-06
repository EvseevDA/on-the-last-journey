package ru.onthelastjourney.backend.mapper;

import ru.onthelastjourney.backend.dto.EmployeeDto;
import ru.onthelastjourney.backend.entity.Employee;

import java.util.List;

public class EmployeeMapper {

    public static EmployeeDto toDto(Employee employee) {
        return new EmployeeDto(
                employee.getSurname(),
                employee.getName(),
                employee.getPatronymic(),
                employee.getJobTitle(),
                employee.getBirthday(),
                employee.getHireDate(),
                employee.getCountry(),
                employee.getRegion(),
                employee.getCity(),
                employee.getDistrict(),
                employee.getStreet(),
                employee.getHouseNumber(),
                employee.getApartamentNumber(),
                employee.getPhoneNumber(),
                employee.getPhotoUrl(),
                employee.getNote(),
                employee.getReportsTo()
        );
    }

    public static List<EmployeeDto> toDto(List<Employee> employees) {
        return employees.stream()
                .map(EmployeeMapper::toDto)
                .toList();
    }

    public static Employee fromDto(EmployeeDto dto) {
        return Employee.builder()
                .surname(dto.getSurname())
                .name(dto.getName())
                .patronymic(dto.getPatronymic())
                .jobTitle(dto.getJobTitle())
                .birthday(dto.getBirthday())
                .hireDate(dto.getHireDate())
                .country(dto.getCountry())
                .region(dto.getRegion())
                .city(dto.getCity())
                .district(dto.getDistrict())
                .street(dto.getStreet())
                .houseNumber(dto.getHouseNumber())
                .apartamentNumber(dto.getApartamentNumber())
                .phoneNumber(dto.getPhoneNumber())
                .photoUrl(dto.getPhotoUrl())
                .note(dto.getNote())
                .reportsTo(dto.getReportsTo())
                .build();
    }

    public static List<Employee> fromDto(List<EmployeeDto> dtos) {
        return dtos.stream()
                .map(EmployeeMapper::fromDto)
                .toList();
    }
}
