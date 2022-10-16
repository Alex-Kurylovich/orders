package edu.examples.orders.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@ToString
@Entity
@Data
public class Agent extends Staff {

    @Column
    private String details;

    @ToString.Exclude
    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    private List<Customer> customers;
}
