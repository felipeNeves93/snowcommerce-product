package com.sowcommerceproduct.service.product;

import com.sowcommerceproduct.domain.product.Product;
import com.sowcommerceproduct.port.in.SaveProductPort;
import com.sowcommerceproduct.usecase.SaveProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveProductService implements SaveProductUseCase {

    private final SaveProductPort saveProductPort;
    @Override
    public Product save(Product product) {
        return saveProductPort.save(product);
    }
}
