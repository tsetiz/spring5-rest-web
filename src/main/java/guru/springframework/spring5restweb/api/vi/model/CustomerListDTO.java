package guru.springframework.spring5restweb.api.vi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CustomerListDTO {
    private List<CustomerDTO> customers;
}
