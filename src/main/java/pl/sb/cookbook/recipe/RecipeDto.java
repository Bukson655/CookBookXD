package pl.sb.cookbook.recipe;

public class RecipeDto {

    private Long id;
    private String name;
    private String description;
    private Difficulty difficulty;
    private int timeNeeded;
    private Long categoryId;
    private int popularity;

    public RecipeDto() {}

    public RecipeDto(Long id, String name, String description, Difficulty difficulty, int timeNeeded, Long categoryId, int popularity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.timeNeeded = timeNeeded;
        this.categoryId = categoryId;
        this.popularity = popularity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public int getTimeNeeded() {
        return timeNeeded;
    }

    public void setTimeNeeded(int timeNeeded) {
        this.timeNeeded = timeNeeded;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
}