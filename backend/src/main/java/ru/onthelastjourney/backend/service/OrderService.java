package ru.onthelastjourney.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.onthelastjourney.backend.dto.OrderDto;
import ru.onthelastjourney.backend.entity.Order;
import ru.onthelastjourney.backend.mapper.OrderMapper;
import ru.onthelastjourney.backend.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> getAll() {
        return repository.findAll();
    }

    public Order getById(Long id) {
        return repository.findById(id).get();
    }

    public Order save(OrderDto orderDto) {
        return repository.save(OrderMapper.fromDto(orderDto));
    }

    public List<Order> saveAll(List<OrderDto> orderDtos) {
        return repository.saveAll(OrderMapper.fromDto(orderDtos));
    }

    public Order update(Order order) {
        return repository.save(order);
    }

    public void delete(Order order) {
        repository.delete(order);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
