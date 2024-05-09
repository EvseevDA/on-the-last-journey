package ru.onthelastjourney.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.onthelastjourney.backend.entity.Employee;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderEmployeeDto {

    private Employee employee;

}
