package br.com.jccf.javaspring.order;

import org.junit.jupiter.api.*;
import org.junit.runner.*;
import org.mockito.*;
import org.powermock.core.classloader.annotations.*;
import org.powermock.modules.junit4.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.result.*;
import org.springframework.test.web.servlet.setup.*;

import java.io.*;
import java.net.*;
import java.net.http.*;
import java.util.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CustomerRepository.class)
class CustomerControllerUnitTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerController customerController;

    private MockMvc mockMvc;
    private AutoCloseable autoCloseable;

    @BeforeEach
    public void setUp() throws IOException, InterruptedException {
        Set.of("test", "test1");
        List.of(1, 2, 3);
        Map.of(1, "test");

        switch (1) {
            case 1: System.out.println("test");
            default: System.out.println("test2");
        }

        var httpClient = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                .uri(URI.create("/customers"))
                .GET()
                .build();

        var result = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(result);

        autoCloseable = MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @AfterEach
    public void endUp() throws Exception {
        autoCloseable.close();
    }

    @Test
    public void shouldDeleteCustomer() throws Exception {
        Mockito.doNothing().when(customerRepository).deleteById(1L);

        mockMvc.perform(
                MockMvcRequestBuilders.delete("/customers/{id}", 1L)
        )
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(customerRepository).deleteById(1L);
    }
}
