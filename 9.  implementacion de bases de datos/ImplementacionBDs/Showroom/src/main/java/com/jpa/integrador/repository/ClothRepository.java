package com.jpa.integrador.repository;

import com.jpa.integrador.entity.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothRepository extends JpaRepository<Cloth, Integer> {
    @Query("FROM Cloth")
    List<Cloth> findAllClothes();

    @Query("INSERT INTO Cloth(:c.nombre, :c.marca, :c.color, :c.talle, :c.cantidad, :c.previo_venta)")
    Cloth InsertClothe(@Param("c") Cloth c);

    @Query("FROM Cloth WHERE Cloth.id = :id")
    Cloth findClothe(@Param("id") Integer id);

    @Query("FROM Cloth WHERE Cloth.size = :size")
    List<Cloth> findClotheBySize(@Param("size") String size);

    @Query("FROM Cloth WHERE Cloth.name like '%:name%'")
    List<Cloth> findByNameContainsCloth(@Param("name") String name);
}
