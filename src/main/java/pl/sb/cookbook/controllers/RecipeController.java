package pl.sb.cookbook.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import pl.sb.cookbook.category.CategoryDto;
import pl.sb.cookbook.category.CategoryService;
import pl.sb.cookbook.recipe.RecipeDto;
import pl.sb.cookbook.recipe.RecipeService;

import java.util.List;

@Controller
public class RecipeController {

    private final RecipeService recipeService;
    private final CategoryService categoryService;

    public RecipeController(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
    }

    @GetMapping("/recipe")
    String showSingleRecipe(@RequestParam Long id,
                            Model model) {
        RecipeDto recipeDto = recipeService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        CategoryDto categoryDto = categoryService.findById(recipeDto.getCategoryId());
        model.addAttribute("recipeDto", recipeDto);
        model.addAttribute("categoryDto", categoryDto);
        return "single-recipe";
    }

    @GetMapping("/recipes")
    String showAllRecipes(Model model) {
        List<RecipeDto> recipesDto = recipeService.findAll();
        model.addAttribute("recipesDto", recipesDto);
        return "recipes";
    }

    @GetMapping("/like")
    String likeRecipe(@RequestParam Long id, Model model) {
        recipeService.likeRecipe(id);
        RecipeDto recipeDto = recipeService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("recipeDto", recipeDto);
        return showSingleRecipe(id, model);
    }

    @GetMapping("/delete")
    String deleteRecipe(@RequestParam Long id) {
        recipeService.deleteRecipeById(id);
        return "redirect:/recipes";
    }

    @GetMapping("/add")
    String addRecipe(Model model) {
        RecipeDto recipeDto = new RecipeDto();
        addCategoriesToModel(model);
        model.addAttribute("recipe", recipeDto);
        return "form";
    }

    @GetMapping("/edit")
    String modifyRecipe(@RequestParam Long id, Model model) {
        RecipeDto recipeDto = recipeService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        addCategoriesToModel(model);
        model.addAttribute("recipe", recipeDto);
        return "form";
    }

    @PostMapping("/modify")
    String modify(RecipeDto recipeDto) {
        if (recipeDto.getId() == null) {
            recipeService.add(recipeDto);
        } else {
            recipeService.modify(recipeDto);
        }

        return "redirect:/recipes";
    }

    private void addCategoriesToModel(Model model) {
        List<CategoryDto> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
    }
}