package com.recipes.recipes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe {
    @Id
    private Long id;
    private List<Long> ingredientsIds;
    private String name;

    public Recipe(Long id, List<Long> ingredientsIds, String name) {
        List<Long> temp = (List<Long>) new ArrayList<>(ingredientsIds).clone();
        this.id = id;
        this.ingredientsIds = temp;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public List<Long> getIngredientsIds() {
        List<Long> temp = (List<Long>) new ArrayList<>(ingredientsIds).clone();
        return temp;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIngredientsIds(List<Long> ingredientsIds) {
        List<Long> temp = (List<Long>) new ArrayList<>(ingredientsIds).clone();
        this.ingredientsIds = temp;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", ingredientsIds=" + ingredientsIds +
                ", name='" + name + '\'' +
                '}';
    }
}
