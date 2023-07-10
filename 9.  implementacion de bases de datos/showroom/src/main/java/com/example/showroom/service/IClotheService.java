package com.example.showroom.service;

import com.example.showroom.model.entity.Clothe;

import java.util.List;

public interface IClotheService {
    public Clothe save(Clothe clothe);

    public List<Clothe> findAll();

    public Clothe findById(Integer id);

    public Clothe updateById(Integer id, Clothe clothe);

    public void deleteById(Integer id);

    public List<Clothe> findBySize(String size);

    public List<Clothe> findByName(String name);
}
