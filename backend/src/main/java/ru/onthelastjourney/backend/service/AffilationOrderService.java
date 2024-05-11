package ru.onthelastjourney.backend.service;

import org.springframework.stereotype.Service;
import ru.onthelastjourney.backend.dto.AffilationOrderDto;
import ru.onthelastjourney.backend.repository.AffilationOrderRepository;
import ru.onthelastjourney.backend.util.factory.AffilationOrderFactory;
import ru.onthelastjourney.backend.util.factory.AffilationOrderPkFactory;
import ru.onthelastjourney.backend.util.mapper.AffilationOrderMapper;

import java.util.List;

@Service
public class AffilationOrderService {

    private final AffilationOrderRepository repository;

    public AffilationOrderService(AffilationOrderRepository repository) {
        this.repository = repository;
    }

    public List<AffilationOrderDto> getAllByOrderId(Long id) {
        return AffilationOrderMapper.toDto(repository.findAllWhereOrderIdIs(id));
    }

    public AffilationOrderDto addAffilationToOrderWithId(Long id, AffilationOrderDto dto) {
        return AffilationOrderMapper.toDto(
                repository.save(
                        AffilationOrderFactory.createAffilationOrderByOrderIdAndAffilationOrderDto(id, dto)
                )
        );
    }

    public AffilationOrderDto updateAffilationFromOrderWithId(Long id, AffilationOrderDto dto) {
        return AffilationOrderMapper.toDto(
                repository.save(
                        AffilationOrderFactory.createAffilationOrderByOrderIdAndAffilationOrderDto(id, dto)
                )
        );
    }

    public void deleteAffilationFromOrderWithId(Long id, AffilationOrderDto dto) {
        repository.deleteById(
                AffilationOrderPkFactory.createAffilationOrderPkByOrderIdAndAffilationOrderDto(id, dto)
        );
    }

    public void deleteAffilationFromOrderByOrderIdAndAffilationId(Long orderId, Long affilationId) {
        repository.deleteById(
                AffilationOrderPkFactory.createAffilationOrderPkByOrderIdAndFuneralAffilationId(orderId, affilationId)
        );
    }

}
