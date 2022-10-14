package edu.examples.orders.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public abstract class Staff {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private long id;

    @Column
    @NotNull(message="{NotNull.Staff.firstName}")
    private String firstName;
    
    @Column
    @NotNull(message="{NotNull.Staff.lastName}")
    private String lastName;
    
    @Column
    @NotNull(message="{NotNull.Staff.email}")
    private String email;

    @Column
    @NotNull(message="{NotNull.Staff.phone}")
    private String phone;

    @Column
    @NotNull(message="{NotNull.Staff.role}")
    private String role;

    @Column
    @NotNull(message="{NotNull.Staff.status}")
    private String status;
}
