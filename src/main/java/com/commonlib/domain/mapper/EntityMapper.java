package com.commonlib.domain.mapper;

public interface EntityMapper <T,E> {
    E toEntity(T t);

    T toDto(E e);
}
