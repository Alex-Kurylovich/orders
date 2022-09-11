package edu.examples.orders.service;

import edu.examples.orders.domain.Agent;
import edu.examples.orders.domain.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User saveUser(User user);

    List<User>  findAllUserManager();

    List<User>  findAllUserAgent();

    List<User>  findAllUserTechnician();

    List<Agent>  findAllAgent();
}
