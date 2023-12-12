package com.sowcommerceproduct.service.order;

import com.sowcommerceproduct.domain.order.UpdateStockOrder;
import com.sowcommerceproduct.usecase.order.ProcessOrderUseCase;
import com.sowcommerceproduct.usecase.order.SendOrderUseCase;
import com.sowcommerceproduct.usecase.product.UpdateStockUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProcessOrderService implements ProcessOrderUseCase {

    private final UpdateStockUseCase updateStockUseCase;
    private final SendOrderUseCase sendOrderUseCase;

    @Transactional
    @Override
    public void process(UpdateStockOrder updateStockOrder) {
        log.info("Receiveing order: {} ", updateStockOrder);

        try {

            if (updateStockOrder.shouldUpdateStock()) {
                log.info("Updating stock");
                updateStockUseCase.updateStock(updateStockOrder);
            }
        } catch (Exception e) {

        }

    }
}
