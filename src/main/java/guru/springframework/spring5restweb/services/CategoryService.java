package guru.springframework.spring5restweb.services;

import guru.springframework.spring5restweb.api.vi.model.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryByName(String name);
}
