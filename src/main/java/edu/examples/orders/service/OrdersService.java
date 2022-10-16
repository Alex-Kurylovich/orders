package edu.examples.orders.service;

import edu.examples.orders.domain.*;

import java.util.List;

public interface OrdersService {

    // Staff

    List<Staff> getStaff();

    List<Agent>  getAgents();

    List<Manager> getManagers();

    List<Technician>  getTechnicians();

    <T extends Staff> T saveStaff(T entity);

    // Customers

    List<Customer> getCustomers();

    Customer saveCustomer(Customer customer);

    void saveAgentCustomer(Agent a, Customer c);
}
