package pl.sb.cookbook.recipe;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    List<Recipe> findTop3ByOrderByPopularityDesc();

    List<Recipe> findTop3ByOrderByIdDesc();

    List<Recipe> findAllByCategoryId(Long id);

}