package com.recipes.ingredients;

import Exceptions.IngredientRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    @Autowired
    private final IngredientRepository rr;

    public IngredientService(IngredientRepository rr) {
        this.rr = rr;
    }

    public List<Ingredient> getAllIngredients() {
        return this.rr.findAll();
    }

    public Ingredient getIngredientById(Long id) throws IngredientRequestException {
        Optional<Ingredient> r =  this.rr.findById(id);
        if (r.isPresent()) {
            return r.get();
        } else
            throw new IngredientRequestException("Recipe does not exist");
    }

    public void addIngredient(Ingredient r) {
        this.rr.save(r);
    }

    public void updateIngredient(Long id, Ingredient r) {
        if (this.rr.existsById(id)) {
            this.rr.save(r);
        } else
            throw new IngredientRequestException("Recipe does not exist");
    }

    public void deleteIngredient(Long id) {
        if (this.rr.existsById(id)) {
            this.rr.deleteById(id);
        } else
            throw new IngredientRequestException("Recipe does not exist");
    }

}
