package com.jef.pearl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Jewel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String material;
    private double weight;
    private String weightUnit;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    public Jewel(String material, double weight, String weightUnit) {
        this.material = material;
        this.weight = weight;
        this.weightUnit = weightUnit;
    }

    public Jewel(Long id, String material, double weight, String weightUnit) {
        this.id = id;
        this.material = material;
        this.weight = weight;
        this.weightUnit = weightUnit;
    }
}
