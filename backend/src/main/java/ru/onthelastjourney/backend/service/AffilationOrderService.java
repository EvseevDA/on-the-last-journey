package ru.onthelastjourney.backend.service;

import org.springframework.stereotype.Service;
import ru.onthelastjourney.backend.dto.AffilationOrderDto;
import ru.onthelastjourney.backend.repository.AffilationOrderRepository;
import ru.onthelastjourney.backend.util.mapper.AffilationOrderMapper;

import java.util.List;

@Service
public class AffilationOrderService extends AbstractService {

    private final AffilationOrderRepository repository;

    public AffilationOrderService(AffilationOrderRepository repository) {
        this.repository = repository;
    }

    public List<AffilationOrderDto> getAllByOrderId(Long id) {
        return AffilationOrderMapper.toDto(repository.findAllByOrderId(id));
    }

    public AffilationOrderDto addAffilationToOrderWithId(Long id, AffilationOrderDto dto) {
        repository.saveByDbFields(
                id,
                dto.getAffilation().getId(),
                dto.getPrice(),
                dto.getAffilationCount(),
                dto.getPercentDiscount()
        );

        return dto;
    }

    public AffilationOrderDto updateAffilationFromOrderWithId(Long id, AffilationOrderDto dto) {
        repository.updateByDbFields(
                id,
                dto.getAffilation().getId(),
                dto.getPrice(),
                dto.getAffilationCount(),
                dto.getPercentDiscount()
        );

        return dto;
    }

    public void deleteAffilationFromOrderWithId(Long id, AffilationOrderDto dto) {
        repository.deleteByDbFields(id, dto.getAffilation().getId());
    }

    public void deleteAffilationFromOrderByOrderIdAndAffilationId(Long orderId, Long affilationId) {
        repository.deleteByDbFields(orderId, affilationId);
    }

}
