package edu.examples.orders.repository;

import edu.examples.orders.domain.Appointment;
import edu.examples.orders.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>, JpaSpecificationExecutor<Customer>, QuerydslPredicateExecutor<Customer> {
}
