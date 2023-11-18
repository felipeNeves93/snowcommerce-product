package com.sowcommerceproduct.adapter.mapper;

import com.sowcommerceproduct.adapter.dto.ProductDTO;
import com.sowcommerceproduct.adapter.persistence.entity.ProductEntity;
import com.sowcommerceproduct.domain.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper implements Mapper<ProductDTO, Product, ProductEntity> {

    private final CategoryMapper categoryMapper;

    @Override
    public Product fromEntity(ProductEntity entity) {
        return Product.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .category(categoryMapper.fromEntity(entity.getCategory()))
                .amountInStock(entity.getAmountInStock())
                .price(entity.getPrice())
                .build();
    }

    @Override
    public Product fromDTO(ProductDTO dto) {
        return Product.builder()
                .id(dto.id())
                .name(dto.name())
                .description(dto.description())
                .category(categoryMapper.fromDTO(dto.category()))
                .amountInStock(dto.amountInStock())
                .price(dto.price())
                .build();
    }

    @Override
    public ProductEntity toEntity(Product domain) {
        return ProductEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .category(categoryMapper.toEntity(domain.getCategory()))
                .amountInStock(domain.getAmountInStock())
                .price(domain.getPrice())
                .build();
    }

    @Override
    public ProductDTO toDTO(Product domain) {
        return ProductDTO.builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .category(categoryMapper.toDTO(domain.getCategory()))
                .amountInStock(domain.getAmountInStock())
                .price(domain.getPrice())
                .build();
    }
}
