package edu.examples.orders;

import edu.examples.orders.domain.Agent;
import edu.examples.orders.domain.User;
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
public class UsersApplicationTests {


    @Autowired
    MockMvc mockMvc;

    @Test
    public void testListUsers() throws Exception {
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/users")
                                .characterEncoding(UTF_8.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String resulAsString = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> data = objectMapper.readValue(resulAsString, new TypeReference<List<User>>(){});
        assertTrue(data.size() == 4);
    }

    @Test
    public void testSaveUser() throws Exception {
        User request = new User();
        request.setId(5);
        request.setFirstName("Justin");
        request.setLastName("Wright");
        request.setEmail("abc4@gmail.com");
        request.setPhone("416-1122-1375");
        request.setRole("agent");
        request.setStatus("active");

        ObjectMapper objectMapper = new ObjectMapper();
        String body = objectMapper.writeValueAsString(request);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String resultString = result.getResponse().getContentAsString();

        assertNotNull(resultString);
    }

    @Test
    public void testListUsersManager() throws Exception {
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/users/manager")
                                .characterEncoding(UTF_8.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String resulAsString = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> data = objectMapper.readValue(resulAsString, new TypeReference<List<User>>(){});
        assertTrue(data.size() == 1);
    }

    @Test
    public void testListUsersAgent() throws Exception {
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/users/agent")
                                .characterEncoding(UTF_8.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String resulAsString = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> data = objectMapper.readValue(resulAsString, new TypeReference<List<User>>(){});
        assertTrue(data.size() == 1);
    }

    @Test
    public void testListUsersTechnician() throws Exception {
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/users/technician")
                                .characterEncoding(UTF_8.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String resulAsString = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> data = objectMapper.readValue(resulAsString, new TypeReference<List<User>>(){});
        assertTrue(data.size() == 2);
    }

    @Test
    public void testFindAgent() throws Exception {
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/agent")
                                .characterEncoding(UTF_8.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String resulAsString = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Agent> data = objectMapper.readValue(resulAsString, new TypeReference<List<Agent>>(){});
        assertTrue(data.size() == 1);
    }
}
