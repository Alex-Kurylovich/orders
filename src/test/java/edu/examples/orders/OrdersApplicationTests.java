package edu.examples.orders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.examples.orders.domain.*;
import edu.examples.orders.dto.StaffRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@TestPropertySource(locations = {"classpath:test.properties"})
public class OrdersApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testListStaff() throws Exception {
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/staff-list")
                                .characterEncoding(UTF_8.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String resulAsString = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<?> data = objectMapper.readValue(resulAsString, new TypeReference<List<?>>(){});
        assertFalse(data.isEmpty());
    }

    @Test
    public void testSaveManager() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String body = objectMapper.writeValueAsString(createManager());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/manager-save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String resultString = result.getResponse().getContentAsString();

        assertNotNull(resultString);
    }

    @Test
    public void testSaveAgent() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String body = objectMapper.writeValueAsString(createAgent());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/agent-save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String resultString = result.getResponse().getContentAsString();

        assertNotNull(resultString);
    }

    @Test
    public void testSaveTechnician() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String body = objectMapper.writeValueAsString(createTechnician());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/technician-save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String resultString = result.getResponse().getContentAsString();

        assertNotNull(resultString);
    }

    @Test
    public void testListManagers() throws Exception {
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/managers-list")
                                .characterEncoding(UTF_8.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String resulAsString = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Manager> data = objectMapper.readValue(resulAsString, new TypeReference<List<Manager>>(){});
        assertFalse(data.isEmpty());
    }

    @Test
    public void testListAgents() throws Exception {
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/agents-list")
                                .characterEncoding(UTF_8.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String resulAsString = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Agent> data = objectMapper.readValue(resulAsString, new TypeReference<List<Agent>>(){});
        assertFalse(data.isEmpty());
    }

    @Test
    public void testListTechnicians() throws Exception {
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/technicians-list")
                                .characterEncoding(UTF_8.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String resulAsString = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Technician> data = objectMapper.readValue(resulAsString, new TypeReference<List<Technician>>(){});
        assertFalse(data.isEmpty());
    }

    @Test
    public void testListCustomers() throws Exception {
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/customers-list")
                                .characterEncoding(UTF_8.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String resulAsString = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Customer> data = objectMapper.readValue(resulAsString, new TypeReference<List<Customer>>(){});
        assertFalse(data.isEmpty());
    }

    @Test
    public void testSaveCustomer() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String body = objectMapper.writeValueAsString(createCustomer());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/customer-save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String resultString = result.getResponse().getContentAsString();

        assertNotNull(resultString);
    }

    @Test
    public void testMakeAppointment() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String body = objectMapper.writeValueAsString(createAppointment());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/make-appointment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String resultString = result.getResponse().getContentAsString();

        assertNotNull(resultString);
    }

    private Manager createManager() {
        Manager request = new Manager();
        request.setFirstName("Martha");
        request.setLastName("Peck");
        request.setEmail("manager.martha@gmail.com");
        request.setPhone("416-5122-1371");
        request.setRole(StaffRole.MANAGER.name());
        request.setStatus("ACTIVE");
        request.setDetails("Manager details - Martha");
        return request;
    }

    private Agent createAgent() {
        Agent request = new Agent();
        request.setFirstName("Stephanie");
        request.setLastName("Hall");
        request.setEmail("agent.stephanie@gmail.com");
        request.setPhone("416-5122-1372");
        request.setRole(StaffRole.AGENT.name());
        request.setStatus("ACTIVE");
        request.setDetails("Agent details - Stephanie");
        return request;
    }

    private Technician createTechnician() {
        Technician request = new Technician();
        request.setFirstName("Danielle");
        request.setLastName("Golden");
        request.setEmail("technician.danielle@gmail.com");
        request.setPhone("416-5122-1373");
        request.setRole(StaffRole.TECHNICIAN.name());
        request.setStatus("ACTIVE");
        request.setDetails("Technician details - Danielle");
        return request;
    }

    private Customer createCustomer() {
        Customer request = new Customer();
        request.setFirstName("Paula");
        request.setLastName("Reyes");
        request.setEmail("customer5@gmail.com");
        request.setPhone("647-220-0985");
        request.setStreet("2307 Islington Ave");
        request.setCity("Toronto");
        request.setProvince("Ontario");
        request.setZipCode("M8V3B6");
        return request;
    }


    private Appointment createAppointment() {
        Agent a = new Agent(2L);
        Technician t = new Technician(5L);
        Appointment appointment = new Appointment();
        appointment.setAgent(a);
        appointment.setTechnician(t);
        appointment.setReason("Help me please");
        return appointment;
    }
}
