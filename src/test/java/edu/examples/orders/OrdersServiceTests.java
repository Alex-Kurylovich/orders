package edu.examples.orders;

import edu.examples.orders.domain.Agent;
import edu.examples.orders.domain.Manager;
import edu.examples.orders.domain.Staff;
import edu.examples.orders.domain.Technician;
import edu.examples.orders.service.OrdersService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Disabled
@AutoConfigureMockMvc
@Transactional
@TestPropertySource(locations = {"classpath:test.properties"})
@Sql({"/populate_data_srv.sql"})
public class OrdersServiceTests {

    @Autowired
    private OrdersService ordersService;

    @Test
    public void testServiceAddStaff() throws Exception {
        Manager manager = createManager();
        Staff result1 = ordersService.saveStaff(manager);
        System.out.println(result1);

        Agent agent = createAgent();
        Staff result2 = ordersService.saveStaff(agent);
        System.out.println(result2);

        Technician technician = createTechnician();
        Staff result3 = ordersService.saveStaff(technician);
        System.out.println(result3);

        List<Staff> data = ordersService.getStaff();
        System.out.println(data);

        assertTrue(data.size() == 3);    }

    private Manager createManager() {
        Manager staff = new Manager();
        staff.setFirstName("Pam");
        staff.setLastName("Martinez");
        staff.setEmail("manager1@gmail.com");
        staff.setPhone("416-1122-1371");
        staff.setRole("manager");
        staff.setStatus("active");
        staff.setDetails("Manager details");
        return staff;
    }

    private Agent createAgent() {
        Agent staff = new Agent();
        staff.setFirstName("Maria");
        staff.setLastName("Barnes");
        staff.setEmail("agent1@gmail.com");
        staff.setPhone("416-1122-1372");
        staff.setRole("agent");
        staff.setStatus("active");
        staff.setDetails("Agent details");
        return staff;
    }

    private Technician createTechnician() {
        Technician staff = new Technician();
        staff.setFirstName("Brandon");
        staff.setLastName("Charles");
        staff.setEmail("technician1@gmail.com");
        staff.setPhone("416-1122-1373");
        staff.setRole("technician");
        staff.setStatus("active");
        staff.setDetails("Technician details");
        return staff;
    }
}
