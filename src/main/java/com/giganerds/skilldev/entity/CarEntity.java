package com.giganerds.skilldev.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {

private Long id;
private String model;
private String carcode;
private LocalDate modelyear;
private String fueltype;
private String color;



}
