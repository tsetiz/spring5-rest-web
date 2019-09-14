package guru.springframework.spring5restweb.repositories;

import guru.springframework.spring5restweb.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
