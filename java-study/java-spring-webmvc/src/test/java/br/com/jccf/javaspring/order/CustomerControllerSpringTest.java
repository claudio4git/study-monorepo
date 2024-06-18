package br.com.jccf.javaspring.order;

import com.fasterxml.jackson.databind.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.result.*;

import java.util.*;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerSpringTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        customerRepository.deleteAll();
        customerRepository.saveAll(
                Arrays.asList(
                        new Customer(1L, "Maria"),
                        new Customer(2L, "John")
                )
        );
    }

    @Test
    public void shouldReturnOkGetAll() throws Exception {
        mockMvc.perform(
                    MockMvcRequestBuilders.get("/customers")
                            .param("page", "0")
                            .param("size", "10")
                            .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].name").value("Maria"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[1].name").value("John"));
    }

    @Test
    public void shouldReturnOkGetAllEmptyForPage1() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers")
                                .param("page", "1")
                                .param("size", "10")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").isEmpty());
    }

    @Test
    public void shouldReturnOneCustomer() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/{id}", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Maria"));
    }

    @Test
    public void shouldCreateCustomer() throws Exception {
        var customer = new Customer(3L, "Peter");

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/customers")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(customer))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Peter"));
    }

    @Test
    public void shouldDeleteCustomer() throws Exception {
        customerRepository.saveAll(
                List.of(
                        new Customer(4L, "Saul")
                )
        );

        mockMvc.perform(
                        MockMvcRequestBuilders.delete("/customers/{id}", 4)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
