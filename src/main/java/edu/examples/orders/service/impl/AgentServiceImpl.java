package edu.examples.orders.service.impl;

import edu.examples.orders.domain.Customer;
import edu.examples.orders.repository.CustomerRepository;
import edu.examples.orders.service.AgentService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AgentServiceImpl implements AgentService {

    private CustomerRepository customerRepository;

    public AgentServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }
}
