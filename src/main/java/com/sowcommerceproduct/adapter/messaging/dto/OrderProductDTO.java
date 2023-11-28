package com.sowcommerceproduct.adapter.messaging.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record OrderProductDTO(Long id, int amount, double price, LocalDateTime createdDate) {
}
