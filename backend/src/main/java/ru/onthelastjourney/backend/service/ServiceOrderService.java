package ru.onthelastjourney.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.onthelastjourney.backend.dto.ServiceOrderDto;
import ru.onthelastjourney.backend.repository.ServiceOrderRepository;
import ru.onthelastjourney.backend.util.mapper.ServiceOrderMapper;

import java.util.List;

@Service
public class ServiceOrderService extends AbstractService {

    private final ServiceOrderRepository repository;

    @Autowired
    public ServiceOrderService(ServiceOrderRepository repository) {
        this.repository = repository;
    }

    public List<ServiceOrderDto> getAllByOrderId(Long id) {
        return ServiceOrderMapper.toDto(repository.findAllByOrderId(id));
    }

    public ServiceOrderDto addServiceToOrderWithId(Long id, ServiceOrderDto dto) {
        repository.saveByDbFields(id, dto.getService().getId(), dto.getPrice(), dto.getPercentDiscount());

        return dto;
    }

    public ServiceOrderDto updateServiceFromOrderWithId(Long id, ServiceOrderDto dto) {
        repository.updateByDbFields(id, dto.getService().getId(), dto.getPrice(), dto.getPercentDiscount());

        return dto;
    }

    public void deleteServiceFromOrderWithId(Long id, ServiceOrderDto dto) {
        repository.deleteByOrderIdAndServiceId(id, dto.getService().getId());
    }

    public void deleteServiceFromOrderByOrderIdAndServiceId(Long orderId, Long serviceId) {
        repository.deleteByOrderIdAndServiceId(orderId, serviceId);
    }

}
