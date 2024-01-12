package com.recipes.recipes;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<PreparationStepId> steps;

    private String name;

    public Recipe(Long id, List<PreparationStepId> steps, String name) {
        this.steps = steps;
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public List<PreparationStepId> getSteps() {
        return this.steps;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSteps(List<PreparationStepId> steps) {
        this.steps = steps;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", ingredientsIds=" + steps +
                ", name='" + name + '\'' +
                '}';
    }
}
