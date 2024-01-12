package com.recipes.preparationSteps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/preparationSteps")
public class PreparationStepController {

    @Autowired
    private final PreparationStepService ps;

    public PreparationStepController(PreparationStepService ps) {
        this.ps = ps;
    }

    @GetMapping
    public List<PreparationStep> getAllPreparationSteps(){
        return this.ps.getAllPreparationSteps();
    }

    @GetMapping("/{id}")
    public PreparationStep getPreparationStepById(@PathVariable Long id){
        return this.ps.getPreparationStepById(id);
    }


    @PostMapping
    public void addPreparationStep(@RequestBody PreparationStep r){
        this.ps.addPreparationStep(r);
    }

    @PutMapping("/{id}")
    public void updatePreparationStep(@PathVariable Long id, @RequestBody PreparationStep r){
        this.ps.updatePreparationStep(id, r);
    }

    @DeleteMapping("/{id}")
    public void deletePreparationStep(@PathVariable Long id){
        this.ps.deletePreparationStep(id);
    }


}
