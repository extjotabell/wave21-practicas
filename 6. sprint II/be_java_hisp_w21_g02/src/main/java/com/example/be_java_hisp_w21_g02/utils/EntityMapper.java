package com.example.be_java_hisp_w21_g02.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EntityMapper<T, S> {

    private static final ObjectMapper mapper = new ObjectMapper();

    public S toDto(T entity, Class<S> dto){
        return mapper.convertValue(entity, dto);
    }

    public T toEntity(S dto, Class<T> entity){
        return mapper.convertValue(dto, entity);
    }

}
