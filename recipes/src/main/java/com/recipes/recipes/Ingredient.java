package com.recipes.recipes;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ingredient {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
