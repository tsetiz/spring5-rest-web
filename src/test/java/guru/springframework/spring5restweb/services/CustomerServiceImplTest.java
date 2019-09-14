package guru.springframework.spring5restweb.services;

import guru.springframework.spring5restweb.api.vi.mapper.CustomerMapper;
import guru.springframework.spring5restweb.api.vi.model.CustomerDTO;
import guru.springframework.spring5restweb.domain.Customer;
import guru.springframework.spring5restweb.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CustomerServiceImplTest {

    @Mock
    CustomerRepository customerRepository;
    CustomerService customerService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        customerService = new CustomerServiceImpl(customerRepository, CustomerMapper.INSTANCE);
    }

    @Test
    public void getAllCustomers() {
        Customer customer1 = new Customer();
        customer1.setId(1L);

        Customer customer2 = new Customer();
        customer2.setId(2L);

        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer1, customer2));

        List<CustomerDTO> customers = customerService.getAllCustomers();
        assertEquals(2, customers.size());
    }

    @Test
    public void getCustomerById() {
        Customer customer1 = new Customer();
        customer1.setId(1L);

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer1));

        assertEquals(Long.valueOf(1L), customerService.getCustomerById(1L).getId());
    }
}