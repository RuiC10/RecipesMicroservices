package com.recipes.preparationSteps;

import com.recipes.preparationSteps.Exceptions.PStepRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreparationStepService {

    @Autowired
    private final PreparationStepRepository repo;

    public PreparationStepService(PreparationStepRepository repo) {
        this.repo = repo;
    }

    public List<PreparationStep> getAllPreparationSteps() {
        return this.repo.findAll();
    }

    public PreparationStep getPreparationStepById(Long id) {
        Optional<PreparationStep> ps = this.repo.findById(id);

        if(ps.isPresent())
            return ps.get();
        else
            throw new PStepRequestException("Preparation step not found");
    }

    public void addPreparationStep(PreparationStep r) {
        this.repo.save(r);
    }

    public void deletePreparationStep(Long id) {
        if(this.repo.existsById(id))
            this.repo.deleteById(id);
        else
            throw new PStepRequestException("Preparation step not found");
    }

    public void updatePreparationStep(Long id, PreparationStep r) {
        if(this.repo.existsById(id))
            this.repo.save(r);
        else
            throw new PStepRequestException("Preparation step not found");
    }
}
