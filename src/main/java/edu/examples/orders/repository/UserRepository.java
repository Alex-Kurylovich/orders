package edu.examples.orders.repository;

import edu.examples.orders.domain.Agent;
import edu.examples.orders.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource()
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>, QuerydslPredicateExecutor<User> {
    @Query("SELECT u FROM User u WHERE u.role='manager'")
    List<User> findAllUserManager();

    @Query("SELECT u FROM User u WHERE u.role='agent'")
    List<User> findAllUserAgent();

    @Query("SELECT u FROM User u WHERE u.role='technician'")
    List<User> findAllUserTechnician();

    @Query("SELECT a FROM Agent a")
    List<Agent> findAllAgent();

}
