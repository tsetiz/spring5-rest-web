package guru.springframework.spring5restweb.services;

import guru.springframework.spring5restweb.api.vi.model.CustomerDTO;
import guru.springframework.spring5restweb.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(Long id);
}
