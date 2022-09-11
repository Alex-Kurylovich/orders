package edu.examples.orders.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class User {
	
	@Id
	@Column
    private long id;

    @Column
    @NotNull(message="{NotNull.User.firstName}")
    private String firstName;
    
    @Column
    @NotNull(message="{NotNull.User.lastName}")
    private String lastName;
    
    @Column
    @NotNull(message="{NotNull.User.email}")
    private String email;

    @Column
    @NotNull(message="{NotNull.User.phone}")
    private String phone;

    @Column
    @NotNull(message="{NotNull.User.role}")
    private String role;

    @Column
    @NotNull(message="{NotNull.User.status}")
    private String status;
}
