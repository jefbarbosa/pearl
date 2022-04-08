package com.jef.pearl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String cpf;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Jewel> jewels = new ArrayList<>();

    public void addJewel(Jewel jewel) {
        jewels.add(jewel);
        jewel.setCustomer(this);
    }

    public void removeJewel(Jewel jewel) {
        jewels.remove(jewel);
        jewel.setCustomer(null);
    }

    public Customer(String firstName, String cpf) {
        this.firstName = firstName;
        this.cpf = cpf;
    }
}
