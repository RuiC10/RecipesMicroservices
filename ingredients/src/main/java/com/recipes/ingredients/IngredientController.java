package com.recipes.ingredients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ingredients")
public class IngredientController {

    @Autowired
    private final IngredientService rs;

    public IngredientController(IngredientService rs) {
        this.rs = rs;
    }

    @GetMapping
    public List<Ingredient> getAllIngredient(){
        return this.rs.getAllIngredients();
    }

    @GetMapping("/{id}")
    public Ingredient getIngredient(@PathVariable Long id){
        return this.rs.getIngredientById(id);
    }


    @PostMapping
    public void addIngredient(@RequestBody Ingredient r){
        this.rs.addIngredient(r);
    }

    @PutMapping("/{id}")
    public void updateIngredient(@PathVariable Long id, @RequestBody Ingredient r){
        this.rs.updateIngredient(id, r);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Long id){
        this.rs.deleteIngredient(id);
    }
}
