package com.example.testcase.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_case;

    @Column
    private String description;

    @Column
    private Boolean tested;

    @Column
    private Boolean passed;

    @Column
    private int number_of_tries;

    @Column
    private LocalDate last_updated;
}
