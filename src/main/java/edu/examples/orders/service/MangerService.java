package edu.examples.orders.service;

import edu.examples.orders.domain.Customer;
import edu.examples.orders.domain.Technician;

import java.util.List;

public interface MangerService {
    Technician assignTechnician(Customer customer);

    List<Technician> getTechnicians();
}
