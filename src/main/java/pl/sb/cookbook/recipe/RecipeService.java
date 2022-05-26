package pl.sb.cookbook.recipe;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sb.cookbook.category.CategoryService;
import pl.sb.cookbook.exceptions.RecipeNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final CategoryService categoryService;

    public RecipeService(RecipeRepository recipeRepository, CategoryService categoryService) {
        this.recipeRepository = recipeRepository;
        this.categoryService = categoryService;
    }

    @Transactional
    public Recipe add(RecipeDto recipeDto) {
        Recipe recipe = new Recipe(
                recipeDto.getName(),
                recipeDto.getDescription(),
                recipeDto.getDifficulty(),
                recipeDto.getTimeNeeded(),
                categoryService.findCategoryById(recipeDto.getCategoryId()),
                recipeDto.getPopularity());

        return recipeRepository.save(recipe);
    }

    @Transactional
    public void modify(RecipeDto recipeDto) {
        Recipe recipe = recipeRepository.findById(recipeDto.getId()).orElseThrow(RecipeNotFoundException::new);
        recipe.setName(recipeDto.getName());
        recipe.setDescription(recipeDto.getDescription());
        recipe.setDifficulty(recipeDto.getDifficulty());
        recipe.setTimeNeeded(recipeDto.getTimeNeeded());
        recipe.setCategory(categoryService.findCategoryById(recipeDto.getCategoryId()));
        recipe.setPopularity(recipeDto.getPopularity());
    }

    @Transactional
    public void deleteRecipeById(Long id) {
        recipeRepository.deleteById(id);
    }

    public List<RecipeDto> findAll() {
        List<RecipeDto> recipes = new ArrayList<>();
        recipeRepository.findAll().forEach(recipe -> recipes.add(convertToDto(recipe)));
        return recipes;
    }

    public List<RecipeDto> findAllByCategoryId(Long id) {
        List<RecipeDto> recipes = new ArrayList<>();
        recipeRepository.findAllByCategoryId(id).forEach(recipe -> recipes.add(convertToDto(recipe)));
        return recipes;
    }

    @Transactional
    public void likeRecipe(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(RecipeNotFoundException::new);
        recipe.setPopularity(recipe.getPopularity() + 1);
        recipeRepository.save(recipe);
    }

    public Optional<RecipeDto> findById(Long id) {
        return recipeRepository.findById(id).map(this::convertToDto);
    }

    public List<RecipeDto> find3MostPopular() {
        return recipeRepository.findTop3ByOrderByPopularityDesc().stream()
                .map(this::convertToDto).collect(Collectors.toList());
    }

    public List<RecipeDto> find3Latest() {
        return recipeRepository.findTop3ByOrderByIdDesc().stream()
                .map(this::convertToDto).collect(Collectors.toList());
    }

    private RecipeDto convertToDto(Recipe recipe) {
        return new RecipeDto(recipe.getId(),
                recipe.getName(),
                recipe.getDescription(),
                recipe.getDifficulty(),
                recipe.getTimeNeeded(),
                recipe.getCategory().getId(),
                recipe.getPopularity());
    }
}