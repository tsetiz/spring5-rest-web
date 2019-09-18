package guru.springframework.spring5restweb.api.vi.mapper;

import guru.springframework.spring5restweb.api.vi.model.CategoryDTO;
import guru.springframework.spring5restweb.domain.Category;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryMapperTest {

    public static final long ID = 1L;
    public static final String TEST = "Test";
    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    public void categoryToCategoryDTO() {
        Category category = new Category();
        category.setId(ID);
        category.setName(TEST);

        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        assertEquals(Long.valueOf(ID), categoryDTO.getId());
        assertEquals(TEST, categoryDTO.getName());
    }
}