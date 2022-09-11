package edu.examples.orders;

import edu.examples.orders.domain.Customer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@TestPropertySource(locations = {"classpath:test.properties"})
@Sql({"/populate_data.sql"})
class AgentApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testListCustomers() throws Exception {
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/customers")
                                .characterEncoding(UTF_8.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String resulAsString = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Customer> data = objectMapper.readValue(resulAsString, new TypeReference<List<Customer>>(){});
        assertTrue(data.size() == 4);
    }

    @Test
    public void testSaveCustomer() throws Exception {
        Customer request = new Customer();
        request.setId(5);
        request.setFirstName("Paula");
        request.setLastName("Reyes");
        request.setEmail("customer5@gmail.com");
        request.setPhone("647-220-0985");
        request.setStreet("2307 Islington Ave");
        request.setCity("Toronto");
        request.setProvince("Ontario");
        request.setZipCode("M8V3B6");

        ObjectMapper objectMapper = new ObjectMapper();
        String body = objectMapper.writeValueAsString(request);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String resultString = result.getResponse().getContentAsString();

        assertNotNull(resultString);
    }
}
