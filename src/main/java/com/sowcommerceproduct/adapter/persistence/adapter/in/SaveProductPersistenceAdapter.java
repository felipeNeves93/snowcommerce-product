package com.sowcommerceproduct.adapter.persistence.adapter.in;

import com.sowcommerceproduct.adapter.mapper.Mapper;
import com.sowcommerceproduct.adapter.mapper.ProductMapper;
import com.sowcommerceproduct.adapter.persistence.service.SaveProductPersisteceService;
import com.sowcommerceproduct.domain.product.Product;
import com.sowcommerceproduct.port.in.SaveProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveProductPersistenceAdapter implements SaveProductPort {

    private final SaveProductPersisteceService saveProductPersisteceService;
    private final ProductMapper mapper;

    @Override
    public Product save(Product product) {
        var productEntity = mapper.toEntity(product);
        productEntity = saveProductPersisteceService.save(productEntity);

        return mapper.fromEntity(productEntity);
    }
}
