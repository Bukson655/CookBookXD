package pl.sb.cookbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sb.cookbook.category.CategoryDto;
import pl.sb.cookbook.category.CategoryService;
import pl.sb.cookbook.recipe.RecipeDto;
import pl.sb.cookbook.recipe.RecipeService;

import java.util.List;

@Controller
public class CategoryController {

    private final RecipeService recipeService;
    private final CategoryService categoryService;

    public CategoryController(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    String showCategories(Model model) {
        List<CategoryDto> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/category")
    String showSingleCategory(@RequestParam Long id, Model model) {
        CategoryDto category = categoryService.findById(id);
        List<RecipeDto> recipes = recipeService.findAllByCategoryId(id);
        model.addAttribute("category", category);
        model.addAttribute("recipes", recipes);
        return "single-category";
    }
}
