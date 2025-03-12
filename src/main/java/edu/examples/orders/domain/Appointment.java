package edu.examples.orders.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @OneToOne(cascade = CascadeType.REFRESH)
    private Agent agent;

    @OneToOne(cascade = CascadeType.REFRESH)
    private Technician technician;

    @Column
    private String reason;
}