package com.sowcommerceproduct;

import com.sowcommerceproduct.adapter.dto.CategoryDTO;
import com.sowcommerceproduct.adapter.dto.ProductDTO;
import com.sowcommerceproduct.adapter.messaging.dto.OrderDTO;
import com.sowcommerceproduct.adapter.messaging.dto.OrderProductDTO;
import com.sowcommerceproduct.adapter.persistence.entity.CategoryEntity;
import com.sowcommerceproduct.adapter.persistence.entity.ProductEntity;
import com.sowcommerceproduct.domain.product.Category;
import com.sowcommerceproduct.domain.product.Product;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

public final class Helper {

    public static CategoryDTO buildCategoryDTO(Long id) {
        return new CategoryDTO(id, "test_category");
    }

    public static Category buildCategory(Long id) {
        return new Category(id, "test_category", LocalDateTime.now(), LocalDateTime.now());
    }

    public static CategoryEntity buildCategoryEntity(Long id) {
        return new CategoryEntity(id, "test_category", LocalDateTime.now(), LocalDateTime.now());
    }

    public static ProductDTO buildProductDTO(Long id) {
        return ProductDTO.builder()
                .id(id)
                .category(buildCategoryDTO(1L))
                .name("test_product")
                .description("test_description")
                .amountInStock(50)
                .price(500.0)
                .build();
    }

    public static Product buildProduct(Long id) {
        return Product.builder()
                .id(id)
                .category(buildCategory(10L))
                .name("test_product")
                .description("test_description")
                .amountInStock(50)
                .price(500.0)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }

    public static ProductEntity buildProductEntity(Long id) {
        return ProductEntity.builder()
                .id(id)
                .name("test_product")
                .category(buildCategoryEntity(12L))
                .description("test_description")
                .amountInStock(50)
                .price(500.0)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }

    public static OrderDTO buildOrderDTO() {
        return OrderDTO.builder()
                .id(UUID.randomUUID().toString())
                .total(10)
                .products(Collections.singletonList(buildOrderProductDTO(1L)))
                .total(100)
                .build();
    }

    public static OrderProductDTO buildOrderProductDTO(Long id) {
        return OrderProductDTO.builder()
                .amount(5)
                .id(id)
                .price(10)
                .build();
    }
}
