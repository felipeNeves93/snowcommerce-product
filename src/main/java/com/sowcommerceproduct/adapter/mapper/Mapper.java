package com.sowcommerceproduct.adapter.mapper;

/**
 * Define the mapper contracts
 *
 * @param <D> DTO class
 * @param <T> Domain Class
 * @param <E> Entity Class
 */
public interface Mapper<D, T, E> {

    T fromEntity(E entity);
    T fromDTO(D dto);
    E toEntity(T domain);
    D toDTO(T domain);



}
