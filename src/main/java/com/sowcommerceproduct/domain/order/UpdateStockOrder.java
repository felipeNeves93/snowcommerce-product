package com.sowcommerceproduct.domain.order;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateStockOrder {

    private Order order;
    private Status status;

    public boolean shouldUpdateStock() {
        return status.isAddProductToStock() || status.isRemoveProductFromStock();
    }
}
