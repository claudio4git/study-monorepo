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
    public void setUp() {
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
