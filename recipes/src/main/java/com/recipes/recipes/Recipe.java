package com.recipes.recipes;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.grammars.hql.HqlParser;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<PreparationStep> steps;
    private String name;


    public Recipe(Long id, List<PreparationStep> steps, String name) {
        List<PreparationStep> temp = (List<PreparationStep>) new ArrayList<>(steps).clone();
        this.id = id;
        this.steps = temp;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public List<PreparationStep> getSteps() {
        List<PreparationStep> temp = (List<PreparationStep>) new ArrayList<>(steps).clone();
        return temp;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSteps(List<PreparationStep> steps) {
        List<PreparationStep> temp = (List<PreparationStep>) new ArrayList<>(steps).clone();
        this.steps = temp;
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
