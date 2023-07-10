package com.example.RelacionesJpaW21.repository;

import com.example.RelacionesJpaW21.entity.OneToMany.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepository extends JpaRepository<Cart,Long> {
}
