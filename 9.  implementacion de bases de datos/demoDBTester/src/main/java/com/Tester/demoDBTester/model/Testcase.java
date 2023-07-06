package com.Tester.demoDBTester.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Testcase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_case;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer number_of_tries;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate last_update;

}
