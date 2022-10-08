package edu.examples.orders.repository;

import edu.examples.orders.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Integer>, JpaSpecificationExecutor<Staff>, QuerydslPredicateExecutor<Staff> {

    @Query("SELECT u FROM Staff u WHERE u.role='manager'")
    List<Staff> findManagers();

    @Query("SELECT u FROM Staff u WHERE u.role='agent'")
    List<Staff> findAgents();

    @Query("SELECT u FROM Staff u WHERE u.role='technician'")
    List<Staff> findTechnicians();
}
