package com.sowcommerceproduct.domain.order;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    private String id;
    private List<OrderProduct> products;
    private double total;
    private Status status;

    public boolean shouldUpdateStock() {
        return status.isAddProductToStock() || status.isRemoveProductFromStock();
    }
}
