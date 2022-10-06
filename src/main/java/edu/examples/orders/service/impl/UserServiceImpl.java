package edu.examples.orders.service.impl;

import edu.examples.orders.domain.Agent;
import edu.examples.orders.domain.Staff;
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

    public List<Staff> getUsers() {
        return userRepository.findAll();
    }
    
    public Staff saveUser(Staff staff) {
    	return userRepository.save(staff);
    }

    public List<Staff>  findAllUserManager() {
        return userRepository.findAllUserManager();
    }

    public List<Staff>  findAllUserAgent() {
        return userRepository.findAllUserAgent();
    }

    public List<Staff>  findAllUserTechnician() {
        return userRepository.findAllUserTechnician();
    }

    public List<Agent>  findAllAgent() {
        return userRepository.findAllAgent();
    }
}
