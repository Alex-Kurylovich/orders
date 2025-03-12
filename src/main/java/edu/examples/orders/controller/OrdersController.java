package edu.examples.orders.controller;

import edu.examples.orders.domain.*;
import edu.examples.orders.dto.URLConstants;
import edu.examples.orders.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class OrdersController {

	final
    OrdersService ordersService;

    public OrdersController(@Autowired OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    // Staff requests

	@GetMapping(path = URLConstants.URL_STAFF_LIST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listStaff() {
        log.info("OrdersController: list all staff");
        List<Staff> resource = ordersService.getStaff();
        return ResponseEntity.ok(resource);
    }
	
    @PostMapping(path = URLConstants.URL_MANAGER_SAVE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveManager(@RequestBody Manager staff) {
        log.info("OrdersController: save Manager");
        Manager resource = ordersService.saveStaff(staff);
        return ResponseEntity.ok(resource);
    }

    @PostMapping(path = URLConstants.URL_AGENT_SAVE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveAgent(@RequestBody Agent staff) {
        log.info("OrdersController: save Agent");
        Agent resource = ordersService.saveStaff(staff);
        return ResponseEntity.ok(resource);
    }

    @PostMapping(path = URLConstants.URL_TECHNICIAN_SAVE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveTechnician(@RequestBody Technician staff) {
        log.info("OrdersController: add Technician");
        Technician resource = ordersService.saveStaff(staff);
        return ResponseEntity.ok(resource);
    }

    @GetMapping(path = URLConstants.URL_AGENTS_LIST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listAgents() {
        log.info("OrdersController:  list agents");
        List<Agent> resource = ordersService.getAgents();
        return ResponseEntity.ok(resource);
    }

    @GetMapping(path = URLConstants.URL_MANAGERS_LIST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listManagers() {
        log.info("OrdersController:  list managers");
        List<Manager> resource = ordersService.getManagers();
        return ResponseEntity.ok(resource);
    }

    @GetMapping(path = URLConstants.URL_TECHNICIANS_LIST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listTechnicians() {
        log.info("OrdersController:  list technicians");
        List<Technician> resource = ordersService.getTechnicians();
        return ResponseEntity.ok(resource);
    }

    // Customer requests

    @GetMapping(path = URLConstants.URL_CUSTOMERS_LIST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listCustomers() {
        log.info("OrdersController:  list customers");
        List<Customer> resource = ordersService.getCustomers();
        return ResponseEntity.ok(resource);
    }

    @PostMapping(path = URLConstants.URL_CUSTOMER_SAVE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
        log.info("OrdersController:  add customer");
        Customer resource = ordersService.saveCustomer(customer);
        return ResponseEntity.ok(resource);
    }

    @GetMapping(URLConstants.URL_CUSTOMER + "/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long id) {
        log.info("OrdersController:  get customer");
        Customer resource = ordersService.getCustomerById(id);
        return ResponseEntity.ok(resource);
    }

    @GetMapping(URLConstants.URL_APPOINTMENT + "/{id}")
    public ResponseEntity<?> getAppointment(@PathVariable Long id) {
        log.info("OrdersController:  get appointment");
        Appointment resource = ordersService.getAppointmentById(id);
        return ResponseEntity.ok(resource);
    }

    @PostMapping(path = URLConstants.URL_MAKE_APPOINTMENT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>  makeAppointment(@RequestBody Appointment app) {
        Appointment resource = ordersService.makeAppointment(app);
        return ResponseEntity.ok(resource);
    }
}
