package ru.onthelastjourney.backend.service;

import org.springframework.stereotype.Service;
import ru.onthelastjourney.backend.dto.AffilationOrderDto;
import ru.onthelastjourney.backend.entity.AffilationOrder;
import ru.onthelastjourney.backend.entity.FuneralAffilation;
import ru.onthelastjourney.backend.entity.Order;
import ru.onthelastjourney.backend.entity.compositepk.AffilationOrderPk;
import ru.onthelastjourney.backend.repository.AffilationOrderRepository;
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
                repository.save(createAffilationOrderByOrderIdAndAffilationOrderDto(id, dto))
        );
    }

    public AffilationOrderDto updateAffilationFromOrderWithId(Long id, AffilationOrderDto dto) {
        return AffilationOrderMapper.toDto(
                repository.save(createAffilationOrderByOrderIdAndAffilationOrderDto(id, dto))
        );
    }

    public void deleteAffilationFromOrderWithId(Long id, AffilationOrderDto dto) {
        repository.deleteById(
                createAffilationOrderPkByOrderIdAndAffilationOrderDto(id, dto)
        );
    }

    public void deleteAffilationFromOrderByOrderIdAndAffilationId(Long orderId, Long affilationId) {
        repository.deleteById(
                createAffilationOrderPkByOrderIdAndAffilationId(orderId, affilationId)
        );
    }

    private static Order createOrderByOrderId(Long id) {
        return Order.builder().id(id).build();
    }

    private static FuneralAffilation createFuneralAffilationByFuneralAffilationId(Long id) {
        return FuneralAffilation.builder().id(id).build();
    }

    private static AffilationOrderPk
    createAffilationOrderPkByOrderIdAndAffilationOrderDto(Long id, AffilationOrderDto dto) {
        return new AffilationOrderPk(
                createOrderByOrderId(id),
                dto.getAffilation()
        );
    }

    private static AffilationOrderPk
    createAffilationOrderPkByOrderIdAndAffilationId(Long orderId, Long affilationId) {
        return new AffilationOrderPk(
                createOrderByOrderId(orderId),
                createFuneralAffilationByFuneralAffilationId(affilationId)
        );
    }

    private static AffilationOrder
    createAffilationOrderByOrderIdAndAffilationOrderDto(Long id, AffilationOrderDto dto) {
        return AffilationOrder.builder()
                .pk(createAffilationOrderPkByOrderIdAndAffilationOrderDto(id, dto))
                .price(dto.getPrice())
                .affilationCount(dto.getAffilationCount())
                .percentDiscount(dto.getPercentDiscount())
                .build();
    }
}
