package com.example.RelacionesJpaW21.repository;

import com.example.RelacionesJpaW21.entity.OneToMany.Cart;
import com.example.RelacionesJpaW21.entity.OneToOne.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
}
