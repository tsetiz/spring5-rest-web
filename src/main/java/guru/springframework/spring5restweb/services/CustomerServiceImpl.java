package guru.springframework.spring5restweb.services;

import guru.springframework.spring5restweb.api.vi.mapper.CustomerMapper;
import guru.springframework.spring5restweb.api.vi.model.CustomerDTO;
import guru.springframework.spring5restweb.domain.Customer;
import guru.springframework.spring5restweb.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> {
                    CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
                    customerDTO.setCustomerUrl("/api/v1/customers/" + customer.getId());
                    return customerDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customer -> {
                    CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
                    customerDTO.setCustomerUrl("/api/v1/customers/" + customer.getId());
                    return customerDTO;
                })
                .orElseThrow(RuntimeException::new); //todo implement better exception handling
    }

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
        return saveAndReturnCustomerDTO(customerMapper.customerDtoToCustomer(customerDTO));
    }

    private CustomerDTO saveAndReturnCustomerDTO(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        CustomerDTO returnDto = customerMapper.customerToCustomerDTO(savedCustomer);
        returnDto.setCustomerUrl("/api/v1/customer/" + savedCustomer.getId());
        return returnDto;
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDtoToCustomer(customerDTO);
        customer.setId(id);
        return saveAndReturnCustomerDTO(customer);
    }

    @Override
    public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(customer -> {
            if (customerDTO.getFirstName() != null) {
                customer.setFirstName(customerDTO.getFirstName());
            }
            if (customerDTO.getLastName() != null) {
                customer.setLastName(customerDTO.getFirstName());
            }
            CustomerDTO dto = customerMapper.customerToCustomerDTO(customerRepository.save(customer));
            dto.setCustomerUrl("/api/v1/customer/" + id);
            return dto;
        }).orElseThrow(RuntimeException::new); //todo implement better exception handling
    }
}
