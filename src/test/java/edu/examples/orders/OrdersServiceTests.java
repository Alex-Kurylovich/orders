package edu.examples.orders;

import edu.examples.orders.domain.*;
import edu.examples.orders.dto.StaffRole;
import edu.examples.orders.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@TestPropertySource(locations = {"classpath:test.properties"})
//@Sql({"/populate_data_srv.sql"})
public class OrdersServiceTests {

    @Autowired
    private OrdersService ordersService;

    @Test
    public void testServiceGetStaff() throws Exception {
        List<Staff> staffs = ordersService.getStaff();
        log.info(staffs.toString());
        assertTrue(staffs.size() == 6);

        List<Manager> managers = ordersService.getManagers();
        log.info(managers.toString());
        assertTrue(managers.size() == 1);

        List<Agent> agents = ordersService.getAgents();
        log.info(agents.toString());
        assertTrue(agents.size() == 2);

        List<Technician> technicians = ordersService.getTechnicians();
        log.info(technicians.toString());
        assertTrue(technicians.size() == 3);
    }

    @Test
    public void testServiceSaveStaff() throws Exception {
        Manager manager = ordersService.saveStaff(createManager());
        log.info(manager.toString());

        Agent agent = ordersService.saveStaff(createAgent());
        log.info(agent.toString());

        Technician technician = ordersService.saveStaff(createTechnician());
        log.info(technician.toString());

        List<Staff> staffs = ordersService.getStaff();
        log.info(staffs.toString());
        assertTrue(staffs.size() == 9);

        List<Manager> managers = ordersService.getManagers();
        log.info(managers.toString());
        assertTrue(managers.size() == 2);

        List<Agent> agents = ordersService.getAgents();
        log.info(agents.toString());
        assertTrue(agents.size() == 3);

        List<Technician> technicians = ordersService.getTechnicians();
        log.info(technicians.toString());
        assertTrue(technicians.size() == 4);
    }

    @Test
    public void testServiceSaveAgentCustomer() throws Exception {
        List<Agent> agents = ordersService.getAgents();
        log.info(agents.toString());
        log.info(String.valueOf("agents size: " + agents.size()));
        log.info(String.valueOf("agent[0] customers size: " + agents.get(0).getCustomers().size()));

        List<Customer> customers = ordersService.getCustomers();
        log.info(customers.toString());
        log.info(String.valueOf("customers size: " + customers.size()));

        ordersService.saveAgentCustomer(agents.get(0), customers.get(1));

        agents = ordersService.getAgents();
        log.info(String.valueOf("agents size: " + agents.size()));
        log.info(String.valueOf("agent[0] customers size: " + agents.get(0).getCustomers().size()));
    }

    private Manager createManager() {
        Manager staff = new Manager();
        staff.setFirstName("Martha");
        staff.setLastName("Peck");
        staff.setEmail("manager.martha@gmail.com");
        staff.setPhone("416-5122-1371");
        staff.setRole(StaffRole.MANAGER.name());
        staff.setStatus("ACTIVE");
        staff.setDetails("Manager details - Martha");
        return staff;
    }

    private Agent createAgent() {
        Agent staff = new Agent();
        staff.setFirstName("Stephanie");
        staff.setLastName("Hall");
        staff.setEmail("agent.stephanie@gmail.com");
        staff.setPhone("416-5122-1372");
        staff.setRole(StaffRole.AGENT.name());
        staff.setStatus("ACTIVE");
        staff.setDetails("Agent details - Stephanie");
        return staff;
    }

    private Technician createTechnician() {
        Technician staff = new Technician();
        staff.setFirstName("Danielle");
        staff.setLastName("Golden");
        staff.setEmail("technician.danielle@gmail.com");
        staff.setPhone("416-5122-1373");
        staff.setRole(StaffRole.TECHNICIAN.name());
        staff.setStatus("ACTIVE");
        staff.setDetails("Technician details - Danielle");
        return staff;
    }
}
