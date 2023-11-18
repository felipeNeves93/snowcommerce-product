package com.sowcommerceproduct.adapter.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
public record ProductDTO(Long id, String name, String description, CategoryDTO category, int amountInStock,
                         double price) {
}
