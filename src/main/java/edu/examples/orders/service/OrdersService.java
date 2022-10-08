package edu.examples.orders.service;

import edu.examples.orders.domain.Customer;
import edu.examples.orders.domain.Staff;

import java.util.List;

public interface OrdersService {

    List<Staff> getStaff();

    Staff saveStaff(Staff staff);

    List<Staff>  findManagers();

    List<Staff>  findAgents();

    List<Staff>  findTechnicians();

    List<Customer> getCustomers();

    Customer saveCustomer(Customer customer);
}
