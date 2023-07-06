package com.example.excercise_crud_jpa.service;

import com.example.excercise_crud_jpa.entity.Joya;

import java.util.List;
import java.util.Optional;

public interface IJoyaService {

    Joya saveJoya(Joya joya );
    Optional<Joya> findJoya(Long id);
    List<Joya> findAllJoya();
    Boolean deleteJoya(Long id);
    Boolean updateJoya(Long id);
}
