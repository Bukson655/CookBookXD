package pl.sb.cookbook.category;

import org.springframework.stereotype.Service;
import pl.sb.cookbook.exceptions.CategoryNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> findAll() {
        List<CategoryDto> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(category -> categories.add(convertToDto(category.getId())));
        return categories;
    }

    public CategoryDto findById(Long id) {
        return convertToDto(id);
    }

    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
    }

    public CategoryDto convertToDto(Long id) {
        return categoryRepository.findById(id)
                .map(category -> new CategoryDto(category.getId(),
                        category.getName(),
                        category.getDescription(),
                        category.getImage()))
                .orElseThrow(CategoryNotFoundException::new);
    }
}