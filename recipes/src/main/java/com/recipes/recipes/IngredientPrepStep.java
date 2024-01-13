package com.recipes.recipes;

import lombok.*;

@NoArgsConstructor
@Builder
public class IngredientPrepStep {
    private String ingredientName;
    private String description;

    public IngredientPrepStep(String ingredientName, String description) {
        this.ingredientName = ingredientName;
        this.description = description;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
