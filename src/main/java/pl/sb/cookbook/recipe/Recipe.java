package pl.sb.cookbook.recipe;

import pl.sb.cookbook.category.Category;

import javax.persistence.*;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 1000)
    private String description;
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    private int timeNeeded;
    @ManyToOne
    private Category category;
    private int popularity;

    public Recipe() {
    }

    public Recipe(String name, String description, Difficulty difficulty, int timeNeeded, Category category, int popularity) {
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.timeNeeded = timeNeeded;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

}