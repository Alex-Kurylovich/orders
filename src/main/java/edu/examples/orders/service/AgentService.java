package edu.examples.orders.service;

import edu.examples.orders.domain.Customer;

import java.util.List;

public interface AgentService {

    List<Customer> getCustomers();

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}