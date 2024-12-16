package edu.examples.orders.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Technician extends Staff {

    public Technician() {
    }

    public Technician(Long id ) {
        this.setId(id);
    }

    @Column
    private String details;
}
