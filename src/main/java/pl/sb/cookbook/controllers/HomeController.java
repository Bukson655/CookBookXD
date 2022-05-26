package pl.sb.cookbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sb.cookbook.recipe.*;

import java.util.List;

@Controller
public class HomeController {

    private final RecipeService recipeService;

    public HomeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    String home(Model model) {
        List<RecipeDto> mostPopularList = recipeService.find3MostPopular();
        List<RecipeDto> latest = recipeService.find3Latest();
        model.addAttribute("mostPopularList", mostPopularList);
        model.addAttribute("latest", latest);
        return "home";
    }
}