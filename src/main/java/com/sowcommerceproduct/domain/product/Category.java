package com.sowcommerceproduct.domain.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Category {

    private Long id;
    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
