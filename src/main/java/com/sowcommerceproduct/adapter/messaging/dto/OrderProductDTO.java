package com.sowcommerceproduct.adapter.messaging.dto;

import lombok.Builder;

@Builder
public record OrderProductDTO(Long id, int amount, double price) {
}
