package com.recipes.recipes;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreparationStep {
    private Long ingredientId;
    private String description;

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
