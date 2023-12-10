package com.sowcommerceproduct.domain.order;

import com.sowcommerceproduct.domain.product.Product;
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
}
