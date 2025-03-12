package edu.examples.orders.service.impl;

import edu.examples.orders.commons.I18Constants;
import edu.examples.orders.domain.*;
import edu.examples.orders.exception.NoSuchElementFoundException;
import edu.examples.orders.repository.AppointmentRepository;
import edu.examples.orders.repository.CustomerRepository;
import edu.examples.orders.repository.StaffRepository;
import edu.examples.orders.service.OrdersService;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Component
public class OrdersServiceImpl implements OrdersService {

    final
    private StaffRepository staffRepository;
    final
    private CustomerRepository customerRepository;
    final
    private AppointmentRepository appointmentRepository;
    final
    private MessageSource messageSource;

    public OrdersServiceImpl(StaffRepository staffRepository, CustomerRepository customerRepository, AppointmentRepository appointmentRepository, MessageSource messageSource) {
        this.staffRepository = staffRepository;
        this.customerRepository = customerRepository;
        this.appointmentRepository = appointmentRepository;
        this.messageSource = messageSource;
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

    public void saveAgentCustomer(Agent a, Customer c) {
        // add one to many
        a.getCustomers().add(c);
        // set many to one
        c.setAgent(a);
        customerRepository.save(c);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() ->
                new NoSuchElementFoundException(getLocalMessage(I18Constants.NO_ITEM_FOUND.getKey(), String.valueOf(id))));
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElseThrow(() ->
                new NoSuchElementFoundException(getLocalMessage(I18Constants.NO_ITEM_FOUND.getKey(), String.valueOf(id))));
    }

    public Appointment makeAppointment(Appointment app) {
        Optional<Staff> a = staffRepository.findById(app.getAgent().getId());
        Optional<Staff> t = staffRepository.findById(app.getTechnician().getId());
        app.setAgent((Agent) a.get());
        app.setTechnician((Technician) t.get());
        appointmentRepository.save(app);
        return app;
    }

    private String getLocalMessage(String key, String... params){
        return messageSource.getMessage(key,
                params,
                Locale.ENGLISH);
    }
}
