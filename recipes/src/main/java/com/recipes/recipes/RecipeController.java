package com.recipes.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {

    @Autowired
    private final RecipeService rs;

    public RecipeController(RecipeService rs) {
        this.rs = rs;
    }

    @GetMapping
    public List<Recipe> getAllRecipes(){
        return this.rs.getAllRecipes();
    }

    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable Long id){
        return this.rs.getRecipeById(id);
    }

    @PostMapping
    public void addRecipe(@RequestBody Recipe r){
        this.rs.addRecipe(r);
    }

    @PutMapping("/{id}")
    public void updateRecipe(@PathVariable Long id, @RequestBody Recipe r){
        this.rs.updateRecipe(id, r);
    }

    @GetMapping("/ingredients/{id}")
    public List<Ingredient> getAllIngredientsOfRecipe(@PathVariable Long id){
        return this.rs.getAllIngredientsOfRecipe(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id){
        this.rs.deleteRecipe(id);
    }
}
