package edu.examples.orders.service;

import edu.examples.orders.domain.Agent;
import edu.examples.orders.domain.Staff;

import java.util.List;

public interface UserService {

    List<Staff> getUsers();

    Staff saveUser(Staff staff);

    List<Staff>  findAllUserManager();

    List<Staff>  findAllUserAgent();

    List<Staff>  findAllUserTechnician();

    List<Agent>  findAllAgent();
}
