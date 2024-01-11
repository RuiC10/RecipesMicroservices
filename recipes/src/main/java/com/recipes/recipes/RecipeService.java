package com.recipes.recipes;

import Exceptions.RecipeRequestException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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
        Optional<Recipe> r = this.rr.findById(id);
        List<Ingredient> response = new ArrayList<>();

        if (r.isPresent()){
            for (PreparationStep s : r.get().getSteps())
                response.add(this.ri.getIngredient(s.getIngredientId()));
        } else
            throw new RecipeRequestException("Recipe does not exist");

        return response;
    }
}
