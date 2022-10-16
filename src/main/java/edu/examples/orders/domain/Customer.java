package edu.examples.orders.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@ToString
@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    @NotNull(message="{NotNull.Customer.firstName}")
    private String firstName;

    @Column
    @NotNull(message="{NotNull.Customer.lastName}")
    private String lastName;

    @Column
    @NotNull(message="{NotNull.Customer.email}")
    private String email;

    @Column
    @NotNull(message="{NotNull.Customer.phone}")
    private String phone;

    @Column
    @NotNull(message="{NotNull.Customer.street}")
    private String street;

    @Column
    @NotNull(message="{NotNull.Customer.city}")
    private String city;

    @Column
    @NotNull(message="{NotNull.Customer.province}")
    private String province;

    @Column
    @NotNull(message="{NotNull.Customer.zipCode}")
    private String zipCode;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agent_id", referencedColumnName = "id")
    private Agent agent;
}