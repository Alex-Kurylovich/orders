package edu.examples.orders.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Data
public class Agent extends Staff {

    public Agent() {
    }

    public Agent(Long id ) {
        this.setId(id);
    }

    @Column
    private String details;

    @ToString.Exclude
    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    private List<Customer> customers;

}
