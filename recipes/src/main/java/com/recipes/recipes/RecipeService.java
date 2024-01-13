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

    @Autowired
    private final RecipePreparationStep rp;

    public RecipeService(RecipeRepository rr, RecipeIngredient ri, RecipePreparationStep rp) {
        this.rr = rr;
        this.ri = ri;
        this.rp = rp;
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
        Optional<Recipe> recipe = this.rr.findById(id);
        List<Ingredient> response = new ArrayList<>();
        PreparationStep temp;

        if(recipe.isPresent())
            for (PreparationStepId prId : recipe.get().getSteps()) {
                temp = this.rp.getPrepartionStep(prId.getId());
                response.add(this.ri.getIngredient(temp.getIngredientId()));
            }
        else
            throw new RecipeRequestException("Recipe non existent");

        return response;

    }

    public List<IngredientPrepStep> getFullPreparationSteps(Long id) {
        Optional<Recipe> recipe = this.rr.findById(id);
        List<IngredientPrepStep> response = new ArrayList<>();
        PreparationStep temp;

        if(recipe.isPresent())
            for (PreparationStepId prId : recipe.get().getSteps()) {
                temp = this.rp.getPrepartionStep(prId.getId());
                response.add(new IngredientPrepStep(this.ri.getIngredient(temp.getIngredientId()).getName(), temp.getDescription()));
            }
        else
            throw new RecipeRequestException("Recipe non existent");

        return response;

    }
}
