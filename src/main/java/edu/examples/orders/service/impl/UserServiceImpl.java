package edu.examples.orders.service.impl;

import edu.examples.orders.domain.Agent;
import edu.examples.orders.domain.User;
import edu.examples.orders.repository.UserRepository;
import edu.examples.orders.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    
    public User saveUser(User user) {
    	return userRepository.save(user);
    }

    public List<User>  findAllUserManager() {
        return userRepository.findAllUserManager();
    }

    public List<User>  findAllUserAgent() {
        return userRepository.findAllUserAgent();
    }

    public List<User>  findAllUserTechnician() {
        return userRepository.findAllUserTechnician();
    }

    public List<Agent>  findAllAgent() {
        return userRepository.findAllAgent();
    }
}
