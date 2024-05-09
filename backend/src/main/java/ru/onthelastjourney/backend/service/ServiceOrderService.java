package ru.onthelastjourney.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.onthelastjourney.backend.dto.ServiceOrderDto;
import ru.onthelastjourney.backend.entity.Order;
import ru.onthelastjourney.backend.entity.Service;
import ru.onthelastjourney.backend.entity.ServiceOrder;
import ru.onthelastjourney.backend.entity.compositepk.ServiceOrderPk;
import ru.onthelastjourney.backend.repository.ServiceOrderRepository;
import ru.onthelastjourney.backend.util.mapper.ServiceOrderMapper;

import java.util.List;

@org.springframework.stereotype.Service
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
                repository.save(createServiceOrderByOrderIdAndServiceOrderDto(id, dto))
        );
    }

    public ServiceOrderDto updateServiceFromOrderWithId(Long id, ServiceOrderDto dto) {
        return ServiceOrderMapper.toDto(
                repository.save(createServiceOrderByOrderIdAndServiceOrderDto(id, dto))
        );
    }

    public void deleteServiceFromOrderWithId(Long id, ServiceOrderDto dto) {
        repository.deleteById(
                createServiceOrderPkByOrderIdAndServiceOrderDto(id, dto)
        );
    }

    public void deleteServiceFromOrderByOrderIdAndServiceId(Long orderId, Long serviceId) {
        repository.deleteById(
                createServiceOrderPkByOrderIdAndServiceId(orderId, serviceId)
        );
    }


    /* private section */
    private static Order createOrderByOrderId(Long id) {
        return Order.builder().id(id).build();
    }

    private static Service createServiceByServiceId(Long id) {
        return Service.builder()
                .id(id)
                .build();
    }

    private static ServiceOrderPk createServiceOrderPkByOrderIdAndServiceOrderDto(Long id, ServiceOrderDto dto) {
        return new ServiceOrderPk(
                createOrderByOrderId(id),
                dto.getService()
        );
    }

    private static ServiceOrderPk createServiceOrderPkByOrderIdAndServiceId(Long orderId, Long serviceId) {
        return new ServiceOrderPk(
                createOrderByOrderId(orderId),
                createServiceByServiceId(serviceId)
        );
    }

    private static ServiceOrder createServiceOrderByOrderIdAndServiceOrderDto(Long orderId, ServiceOrderDto dto) {
        return ServiceOrder.builder()
                .pk(createServiceOrderPkByOrderIdAndServiceOrderDto(orderId, dto))
                .price(dto.getPrice())
                .percentDiscount(dto.getPercentDiscount())
                .build();
    }
}
