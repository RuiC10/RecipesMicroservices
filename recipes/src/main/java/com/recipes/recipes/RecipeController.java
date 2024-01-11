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

    @GetMapping("/{recipe-id}")
    public Recipe getAllRecipes(@PathVariable Long id){
        return this.rs.getRecipeById(id);
    }

    @PostMapping
    public void addRecipe(@RequestBody Recipe r){
        this.rs.addRecipe(r);
    }

    @PutMapping("/{recipe-id}")
    public void updateRecipe(@PathVariable Long id, @RequestBody Recipe r){
        this.rs.updateRecipe(id, r);
    }

    @DeleteMapping("/{recipe-id}")
    public void deleteRecipe(@PathVariable Long id){
        this.rs.deleteRecipe(id);
    }
}
