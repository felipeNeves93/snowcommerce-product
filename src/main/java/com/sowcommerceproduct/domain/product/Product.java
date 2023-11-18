package com.sowcommerceproduct.domain.product;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private Long id;
    private String name;
    private String description;
    private Category category;
    private int amountInStock;
    private Double price;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
