package guru.springframework.spring5restweb.api.vi.mapper;

import guru.springframework.spring5restweb.api.vi.model.CategoryDTO;
import guru.springframework.spring5restweb.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);
}
