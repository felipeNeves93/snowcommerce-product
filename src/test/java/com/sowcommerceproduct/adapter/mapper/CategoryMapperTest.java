package com.sowcommerceproduct.adapter.mapper;

import com.sowcommerceproduct.Helper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryMapperTest {

    private CategoryMapper categoryMapper;

    @BeforeEach
    void setup() {
        categoryMapper = new CategoryMapper();
    }

    @DisplayName("When mapping from domain to DTO then should return dto mapped")
    @Test
    void whenMappingFromDomainToDTOThenShouldReturnDTOMapped() {
        var domainObject = Helper.buildCategory(10L);
        var mappedObject = categoryMapper.toDTO(domainObject);

        assertThat(mappedObject.id()).isEqualTo(domainObject.getId());
        assertThat(mappedObject.name()).isEqualTo(domainObject.getName());
    }

    @DisplayName("When mapping from domain to Entity then should return entity mapped")
    @Test
    void whenMappingFromDomainToEntityThenShouldReturnEntityMapped() {
        var domainObject = Helper.buildCategory(10L);
        var mappedObject = categoryMapper.toEntity(domainObject);

        assertThat(mappedObject.getId()).isEqualTo(domainObject.getId());
        assertThat(mappedObject.getName()).isEqualTo(domainObject.getName());
        assertThat(mappedObject.getCreatedDate()).isEqualTo(domainObject.getCreatedDate());
        assertThat(mappedObject.getUpdatedDate()).isEqualTo(domainObject.getUpdatedDate());
    }

    @DisplayName("When mapping from dto to domain then should return dto mapped")
    @Test
    void whenMappingFromDtoToDominThenShouldReturnDTOMapped() {
        var dto = Helper.buildCategoryDTO(10L);
        var mappedObject = categoryMapper.fromDTO(dto);

        assertThat(mappedObject.getId()).isEqualTo(dto.id());
        assertThat(mappedObject.getName()).isEqualTo(dto.name());
        assertThat(mappedObject.getCreatedDate()).isNull();
        assertThat(mappedObject.getUpdatedDate()).isNull();
    }

    @DisplayName("When mapping from entity to Domain then should return domain mapped")
    @Test
    void whenMappingFromEntityToDomainThenShouldReturnDTOMapped() {
        var entity = Helper.buildCategoryEntity(10L);
        var mappedObject = categoryMapper.fromEntity(entity);

        assertThat(mappedObject.getId()).isEqualTo(entity.getId());
        assertThat(mappedObject.getName()).isEqualTo(entity.getName());
        assertThat(mappedObject.getCreatedDate()).isEqualTo(entity.getCreatedDate());
    }
}
