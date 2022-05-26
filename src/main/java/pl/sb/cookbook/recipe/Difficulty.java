package pl.sb.cookbook.recipe;

public enum Difficulty {

    EASY("Łatwe"),
    MEDIUM("Średnie"),
    HARD("Trudne");

    private final String description;

    Difficulty(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}