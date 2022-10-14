package edu.examples.orders.repository;

import edu.examples.orders.domain.Agent;
import edu.examples.orders.domain.Manager;
import edu.examples.orders.domain.Staff;
import edu.examples.orders.domain.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Integer>, JpaSpecificationExecutor<Staff>, QuerydslPredicateExecutor<Staff> {

    @Query("SELECT a FROM Agent a INNER JOIN Staff s ON a.id = s.id")
    List<Agent> getAgents();

    @Query("SELECT m FROM Manager m INNER JOIN Staff s ON m.id = s.id")
    List<Manager> getManagers();

    @Query("SELECT t FROM Technician t INNER JOIN Staff s ON t.id = s.id")
    List<Technician> getTechnicians();
}
