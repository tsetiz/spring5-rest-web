package guru.springframework.spring5restweb.api.vi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CategoryListDTO {
    private List<CategoryDTO> categories;
}
