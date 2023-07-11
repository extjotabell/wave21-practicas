package com.jpa.integrador.repository;

import com.jpa.integrador.dto.response.ClothesListResponseDTO;
import com.jpa.integrador.entity.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothRepository extends JpaRepository<Cloth, Integer> {
    List<Cloth> findBySize(String size);
    List<Cloth> findByName(String name);
}
