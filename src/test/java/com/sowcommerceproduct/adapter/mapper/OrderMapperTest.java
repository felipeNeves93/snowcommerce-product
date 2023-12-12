package com.sowcommerceproduct.adapter.mapper;

import com.sowcommerceproduct.Helper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderMapperTest {

    @DisplayName("When Mapping from DTO then should return order mapped")
    @Test
    void whenMappingFromDTOThenShouldReturnOrderMapped() {
        var orderMapper = new OrderMapper();

        var orderDTO = Helper.buildOrderDTO();
        var mappedOrder = orderMapper.fromDTO(orderDTO);

        assertThat(mappedOrder).isNotNull();
        assertThat(mappedOrder.getId()).isEqualTo(orderDTO.getId());
        assertThat(mappedOrder.getTotal()).isEqualTo(orderDTO.getTotal());
        assertThat(mappedOrder.getStatus()).isNull();
        assertThat(mappedOrder.getProducts()).hasSize(1);
        assertThat(mappedOrder.getProducts().get(0).getId()).isEqualTo(orderDTO.getProducts().get(0).id());
    }
}
