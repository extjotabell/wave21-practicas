package com.example.RelacionesJpaW21.entity.OneToOne;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

@Entity
@Getter
@Setter
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "calle")
    private String street;

    @Column(name = "numero", length = 10)
    private Long number;


    @OneToOne(mappedBy = "address")
    private User user;
}
