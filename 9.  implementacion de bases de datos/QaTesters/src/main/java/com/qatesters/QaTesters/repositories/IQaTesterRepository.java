package com.qatesters.QaTesters.repositories;

import com.qatesters.QaTesters.entities.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQaTesterRepository extends JpaRepository<TestCase, Long> {

}
