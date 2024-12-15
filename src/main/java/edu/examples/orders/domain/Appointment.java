package edu.examples.orders.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

//    @ToString.Exclude
//    @JsonIgnore
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "agent_id", referencedColumnName = "id")
//    private Agent agent;
//@ToString.Exclude
//@OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
//private List<Customer> customers;


    @OneToOne(cascade = CascadeType.REFRESH)
//    @JoinColumn(name = "agent_id", referencedColumnName = "id")
//    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    private Agent agent;

    @OneToOne(cascade = CascadeType.REFRESH)
//    @JoinColumn(name = "technician_id", referencedColumnName = "id")
    private Technician technician;

    @Column
    private String reason;
}