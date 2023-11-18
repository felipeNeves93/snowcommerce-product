package com.sowcommerceproduct.adapter.persistence.repository;

import com.sowcommerceproduct.adapter.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<ProductEntity, Long> {
}
