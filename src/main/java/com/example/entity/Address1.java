package com.example.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
public class Address1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String street;

    @Column
    private String city;

    @OneToOne(mappedBy = "address")
    private Student student;
}
