package edu.examples.orders.service.impl;

import edu.examples.orders.domain.*;
import edu.examples.orders.repository.CustomerRepository;
import edu.examples.orders.repository.StaffRepository;
import edu.examples.orders.service.OrdersService;
import org.springframework.data.domain.Sort;
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
        return staffRepository.findAll(Sort.by(Sort.Direction.ASC, "role"));
    }

    public List<Agent>  getAgents() {
        return staffRepository.getAgents();
    }

    public List<Manager> getManagers() {
        return staffRepository.getManagers();
    }

    public List<Technician>  getTechnicians() {
        return staffRepository.getTechnicians();
    }

    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
