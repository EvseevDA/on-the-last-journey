package ru.onthelastjourney.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.onthelastjourney.backend.dto.OrderDto;
import ru.onthelastjourney.backend.entity.Order;
import ru.onthelastjourney.backend.repository.OrderRepository;
import ru.onthelastjourney.backend.util.exception.EntityNotFoundException;
import ru.onthelastjourney.backend.util.exception.ExceptionSupplier;
import ru.onthelastjourney.backend.util.mapper.OrderMapper;

import java.util.List;

@Service
public class OrderService extends AbstractService {

    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> getAll() {
        return repository.findAll();
    }

    public Order getById(Long id) throws EntityNotFoundException {
        return repository.findById(id).orElseThrow(ExceptionSupplier.orderNotFoundById(id));
    }

    public Order save(OrderDto dto) {
        return repository.save(OrderMapper.fromDto(dto));
    }

    public List<Order> saveAll(List<OrderDto> dtos) {
        return repository.saveAll(OrderMapper.fromDto(dtos));
    }

    public Order update(Order order) {
        return repository.save(order);
    }

    public void delete(Order order) {
        repository.deleteById(order.getId());
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
