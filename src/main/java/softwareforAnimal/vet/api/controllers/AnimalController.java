/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareforAnimal.vet.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softwareforAnimal.vet.bussiness.abstracts.AnimalService;
import softwareforAnimal.vet.core.utilities.results.DataResult;
import softwareforAnimal.vet.entities.concretes.Animal;

/**
 *
 * @author yahya
 */
@RestController
@RequestMapping("api/animals")
@CrossOrigin
public class AnimalController {
    
    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }
    @GetMapping("/getAll")
    public DataResult<List<Animal>> getAll(){
        return this.animalService.getAll();
    }
}
