package com.jef.pearl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "jewel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jewel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String material;
    private double weight;
    private String weightUnit;

    public Jewel(String material, double weight, String weightUnit) {
        this.material = material;
        this.weight = weight;
        this.weightUnit = weightUnit;
    }
}
