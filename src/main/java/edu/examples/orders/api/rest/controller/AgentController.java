package edu.examples.orders.api.rest.controller;

import edu.examples.orders.domain.Customer;
import edu.examples.orders.service.AgentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/")
public class AgentController {

    final
    AgentService agentService;

    public AgentController(@Autowired AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping(path = ApiLinks.LIST_CUSTOMERS)
    public ResponseEntity<?> listCustomers() {
        log.info("AgentController:  list customers");
        List<Customer> resource = agentService.getCustomers();
        return ResponseEntity.ok(resource);
    }

    @PostMapping(path = ApiLinks.ADD_CUSTOMER)
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
        log.info("AgentController:  add customer");
        Customer resource = agentService.saveCustomer(customer);
        return ResponseEntity.ok(resource);
    }
}
