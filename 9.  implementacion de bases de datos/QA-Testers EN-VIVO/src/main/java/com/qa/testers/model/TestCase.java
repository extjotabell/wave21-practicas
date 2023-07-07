package com.qa.testers.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter @Setter
@Entity
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_case")
    private Long idCase;

    @Column(length = 100)
    private String description;

    private Boolean tested;

    private Boolean passed;

    @Column(name = "number_of_tries")
    private Integer numberOfTries;

    @Column(name = "last_update")
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate lastUpdate;
}