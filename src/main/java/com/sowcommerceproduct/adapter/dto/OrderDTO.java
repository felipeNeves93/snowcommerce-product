package com.sowcommerceproduct.adapter.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
    private String id;
    private List<OrderProductDTO> products;
    private double price;
}
