package ru.onthelastjourney.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.onthelastjourney.backend.dto.ServiceOrderDto;
import ru.onthelastjourney.backend.repository.ServiceOrderRepository;
import ru.onthelastjourney.backend.util.factory.ServiceOrderFactory;
import ru.onthelastjourney.backend.util.factory.ServiceOrderPkFactory;
import ru.onthelastjourney.backend.util.mapper.ServiceOrderMapper;

import java.util.List;

@Service
public class ServiceOrderService {

    private final ServiceOrderRepository repository;

    @Autowired
    public ServiceOrderService(ServiceOrderRepository repository) {
        this.repository = repository;
    }

    public List<ServiceOrderDto> getAllByOrderId(Long id) {
        return ServiceOrderMapper.toDto(repository.findAllWhereOrderIdIs(id));
    }

    public ServiceOrderDto addServiceToOrderWithId(Long id, ServiceOrderDto dto) {
        return ServiceOrderMapper.toDto(
                repository.save(
                        ServiceOrderFactory.createServiceOrderByOrderIdAndServiceOrderDto(id, dto)
                )
        );
    }

    public ServiceOrderDto updateServiceFromOrderWithId(Long id, ServiceOrderDto dto) {
        return ServiceOrderMapper.toDto(
                repository.save(
                        ServiceOrderFactory.createServiceOrderByOrderIdAndServiceOrderDto(id, dto)
                )
        );
    }

    public void deleteServiceFromOrderWithId(Long id, ServiceOrderDto dto) {
        repository.deleteById(
                ServiceOrderPkFactory.createServiceOrderByOrderIdAndServiceOrderDto(id, dto)
        );
    }

    public void deleteServiceFromOrderByOrderIdAndServiceId(Long orderId, Long serviceId) {
        repository.deleteById(
                ServiceOrderPkFactory.createServiceOrderPkByOrderIdAndServiceId(orderId, serviceId)
        );
    }

}
