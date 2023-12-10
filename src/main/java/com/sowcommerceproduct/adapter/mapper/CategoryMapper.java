package com.sowcommerceproduct.adapter.mapper;

import com.sowcommerceproduct.adapter.dto.CategoryDTO;
import com.sowcommerceproduct.adapter.persistence.entity.CategoryEntity;
import com.sowcommerceproduct.domain.product.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements Mapper<CategoryDTO, Category, CategoryEntity> {
    @Override
    public Category fromEntity(CategoryEntity entity) {
        return new Category(entity.getId(), entity.getName(), entity.getCreatedDate(), entity.getUpdatedDate());
    }

    @Override
    public Category fromDTO(CategoryDTO dto) {
        return Category.builder()
                .id(dto.id())
                .name(dto.name())
                .build();
    }

    @Override
    public CategoryEntity toEntity(Category domain) {
        return CategoryEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .createdDate(domain.getCreatedDate())
                .updatedDate(domain.getUpdatedDate())
                .build();
    }

    @Override
    public CategoryDTO toDTO(Category domain) {
        return new CategoryDTO(domain.getId(), domain.getName());
    }
}
