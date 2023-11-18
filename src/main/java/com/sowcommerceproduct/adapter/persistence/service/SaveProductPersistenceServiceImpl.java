package com.sowcommerceproduct.adapter.persistence.service;

import com.sowcommerceproduct.adapter.persistence.entity.ProductEntity;
import com.sowcommerceproduct.adapter.persistence.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveProductPersistenceServiceImpl implements SaveProductPersisteceService {

    private final ProductRepository productRepository;

    @Transactional
    @Override
    public ProductEntity save(ProductEntity entity) {
        return productRepository.save(entity);
    }
}
