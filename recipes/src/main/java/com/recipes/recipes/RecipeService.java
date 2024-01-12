package com.recipes.recipes;

import Exceptions.RecipeRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private final RecipeRepository rr;
    @Autowired
    private final RecipeIngredient ri;

    public RecipeService(RecipeRepository rr, RecipeIngredient ri) {
        this.rr = rr;
        this.ri = ri;
    }

    public List<Recipe> getAllRecipes() {
        return this.rr.findAll();
    }

    public Recipe getRecipeById(Long id) throws RecipeRequestException {
        Optional<Recipe> r =  this.rr.findById(id);
        if (r.isPresent()) {
            return r.get();
        } else
            throw new RecipeRequestException("Recipe does not exist");
    }

    public void addRecipe(Recipe r) {
        this.rr.save(r);
    }

    public void updateRecipe(Long id, Recipe r) {
        if (this.rr.existsById(id)) {
            this.rr.save(r);
        } else
            throw new RecipeRequestException("Recipe does not exist");
    }

    public void deleteRecipe(Long id) {
        if (this.rr.existsById(id)) {
            this.rr.deleteById(id);
        } else
            throw new RecipeRequestException("Recipe does not exist");
    }

    public List<Ingredient> getAllIngredientsOfRecipe(Long id) {
        return new ArrayList<>();
    }


}
