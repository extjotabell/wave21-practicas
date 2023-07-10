package com.jpa.integrador.repository;

import com.jpa.integrador.entity.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothRepository extends JpaRepository<Cloth, Integer> {

    List<Cloth> findAllBySize(String size);

    List<Cloth> findAllByNameStartingWith(String name);
}
