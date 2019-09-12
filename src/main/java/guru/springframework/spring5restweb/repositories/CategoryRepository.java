package guru.springframework.spring5restweb.repositories;

import guru.springframework.spring5restweb.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
