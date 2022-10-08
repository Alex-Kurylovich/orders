package edu.examples.orders.controller;

import edu.examples.orders.domain.Customer;
import edu.examples.orders.domain.Staff;
import edu.examples.orders.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/")
public class OrdersController {

    public static final String URL_STAFF_LIST = "/staff-list";
    public static final String URL_STAFF_ADD = "/staff-add";
    public static final String URL_CUSTOMERS_LIST = "/customers-list";
    public static final String URL_CUSTOMER_ADD = "/customer-add";

    public static final String URL_MANAGERS_LIST = "/managers-list";
    public static final String URL_AGENTS_LIST = "/agents-list";
    public static final String URL_TECHNICIANS_LIST = "/technicians-list";

	final
    OrdersService ordersService;

    public OrdersController(@Autowired OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    // Staff requests

	@GetMapping(path = URL_STAFF_LIST)
    public ResponseEntity<?> listStaff() {
        log.info("OrdersController: list all staff");
        List<Staff> resource = ordersService.getStaff();
        return ResponseEntity.ok(resource);
    }
	
	@PostMapping(path = URL_STAFF_ADD)
	public ResponseEntity<?> saveStaff(@RequestBody Staff staff) {
        log.info("OrdersController: add staff");
        Staff resource = ordersService.saveStaff(staff);
        return ResponseEntity.ok(resource);
    }

    @GetMapping(path = URL_MANAGERS_LIST)
    public ResponseEntity<?> listManagers() {
        log.info("OrdersController:  list managers");
        List<Staff> resource = (List<Staff>) ordersService.findManagers();
        return ResponseEntity.ok(resource);
    }
    @GetMapping(path = URL_AGENTS_LIST)
    public ResponseEntity<?> listAgents() {
        log.info("OrdersController:  list agents");
        List<Staff> resource = (List<Staff>) ordersService.findAgents();
        return ResponseEntity.ok(resource);
    }

    @GetMapping(path = URL_TECHNICIANS_LIST)
    public ResponseEntity<?> listTechnicians() {
        log.info("OrdersController:  list technicians");
        List<Staff> resource = (List<Staff>) ordersService.findTechnicians();
        return ResponseEntity.ok(resource);
    }

    // Customer requests

    @GetMapping(path = URL_CUSTOMERS_LIST)
    public ResponseEntity<?> listCustomers() {
        log.info("AgentController:  list customers");
        List<Customer> resource = ordersService.getCustomers();
        return ResponseEntity.ok(resource);
    }

    @PostMapping(path = URL_CUSTOMER_ADD)
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
        log.info("AgentController:  add customer");
        Customer resource = ordersService.saveCustomer(customer);
        return ResponseEntity.ok(resource);
    }
}
