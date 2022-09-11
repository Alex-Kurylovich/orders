package edu.examples.orders.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Agent extends User {

    @Column
    private String details;

}
