package com.sowcommerceproduct.adapter.mapper;

import com.sowcommerceproduct.Helper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductMapperTest {

    private ProductMapper productMapper;

    @BeforeEach
    void setup() {
        var categoryMapper = new CategoryMapper();
        productMapper = new ProductMapper(categoryMapper);
    }

    @DisplayName("When mapping from domain to DTO then should return dto mapped")
    @Test
    void whenMappingFromDomainToDTOThenShouldReturnDTOMapped() {
        var domainObject = Helper.buildProduct(10L);
        var mappedObject = productMapper.toDTO(domainObject);

        assertThat(mappedObject.id()).isEqualTo(domainObject.getId());
        assertThat(mappedObject.name()).isEqualTo(domainObject.getName());
        assertThat(mappedObject.description()).isEqualTo(domainObject.getDescription());
        assertThat(mappedObject.price()).isEqualTo(domainObject.getPrice());
        assertThat(mappedObject.amountInStock()).isEqualTo(domainObject.getAmountInStock());
    }

    @DisplayName("When mapping from domain to Entity then should return entity mapped")
    @Test
    void whenMappingFromDomainToEntityThenShouldReturnEntityMapped() {
        var domainObject = Helper.buildProduct(11L);
        var mappedObject = productMapper.toEntity(domainObject);

        assertThat(mappedObject.getId()).isEqualTo(domainObject.getId());
        assertThat(mappedObject.getName()).isEqualTo(domainObject.getName());
        assertThat(mappedObject.getDescription()).isEqualTo(domainObject.getDescription());
        assertThat(mappedObject.getPrice()).isEqualTo(domainObject.getPrice());
        assertThat(mappedObject.getAmountInStock()).isEqualTo(domainObject.getAmountInStock());
        assertThat(mappedObject.getCreatedDate()).isEqualTo(domainObject.getCreatedDate());
        assertThat(mappedObject.getUpdatedDate()).isEqualTo(domainObject.getUpdatedDate());
    }

    @DisplayName("When mapping from dto to domain then should return dto mapped")
    @Test
    void whenMappingFromDtoToDominThenShouldReturnDTOMapped() {
        var dto = Helper.buildProductDTO(10L);
        var mappedObject = productMapper.fromDTO(dto);

        assertThat(mappedObject.getId()).isEqualTo(dto.id());
        assertThat(mappedObject.getName()).isEqualTo(dto.name());
        assertThat(mappedObject.getDescription()).isEqualTo(dto.description());
        assertThat(mappedObject.getPrice()).isEqualTo(dto.price());
        assertThat(mappedObject.getAmountInStock()).isEqualTo(dto.amountInStock());
    }

    @DisplayName("When mapping from entity to Domain then should return domain mapped")
    @Test
    void whenMappingFromEntityToDomainThenShouldReturnDTOMapped() {
        var entity = Helper.buildProductEntity(10L);
        var mappedObject = productMapper.fromEntity(entity);

        assertThat(mappedObject.getId()).isEqualTo(entity.getId());
        assertThat(mappedObject.getName()).isEqualTo(entity.getName());
        assertThat(mappedObject.getDescription()).isEqualTo(entity.getDescription());
        assertThat(mappedObject.getPrice()).isEqualTo(entity.getPrice());
        assertThat(mappedObject.getAmountInStock()).isEqualTo(entity.getAmountInStock());
        assertThat(mappedObject.getCreatedDate()).isEqualTo(entity.getCreatedDate());
        assertThat(mappedObject.getUpdatedDate()).isEqualTo(entity.getUpdatedDate());
    }
}
