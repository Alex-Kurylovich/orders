package edu.examples.orders.service.impl;

import edu.examples.orders.domain.Customer;
import edu.examples.orders.domain.Staff;
import edu.examples.orders.repository.CustomerRepository;
import edu.examples.orders.repository.StaffRepository;
import edu.examples.orders.service.OrdersService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdersServiceImpl implements OrdersService {

	private StaffRepository staffRepository;
    private CustomerRepository customerRepository;

    public OrdersServiceImpl(StaffRepository staffRepository, CustomerRepository customerRepository) {
        this.staffRepository = staffRepository;
        this.customerRepository = customerRepository;
    }

    public List<Staff> getStaff() {
        return staffRepository.findAll();
    }

    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public List<Staff>  findManagers() {
        return staffRepository.findManagers();
    }

    public List<Staff>  findAgents() {
        return staffRepository.findAgents();
    }

    public List<Staff>  findTechnicians() {
        return staffRepository.findTechnicians();
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
