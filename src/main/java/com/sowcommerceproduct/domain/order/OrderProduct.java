package com.sowcommerceproduct.domain.order;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderProduct {

    private Long id;
    private int amount;
    private double price;
}
