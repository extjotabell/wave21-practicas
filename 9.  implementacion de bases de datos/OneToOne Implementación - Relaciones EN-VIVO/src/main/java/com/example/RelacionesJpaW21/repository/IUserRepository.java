package com.example.RelacionesJpaW21.repository;

import com.example.RelacionesJpaW21.entity.OneToOne.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
}
