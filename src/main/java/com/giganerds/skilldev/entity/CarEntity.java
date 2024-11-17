package com.giganerds.skilldev.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    private String model;

    @Basic(optional = false)
    private String carcode;

    @Basic(optional = false)
    private LocalDate modelyear;

    @Basic(optional = false)
    private String fueltype;

    @Basic(optional = false)
    private String color;



}
