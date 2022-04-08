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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import softwareforAnimal.vet.bussiness.abstracts.AnimalService;
import softwareforAnimal.vet.core.utilities.results.DataResult;
import softwareforAnimal.vet.dataAccess.abstracts.AnimalDao;
import softwareforAnimal.vet.entities.concretes.Animal;

/**
 *
 * @author yahya
 */
@RestController
@RequestMapping("/")
@CrossOrigin
public class AnimalController {

    private AnimalService animalService;

    @Autowired
    private AnimalDao animalDao;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/")
    public ModelAndView Main() {
        ModelAndView m = new ModelAndView("index");
        m.addObject("animals",this.animalService.getAll().getData());
        return m;
    }

    @GetMapping("AnimalList")
    public ModelAndView getAll() {
        ModelAndView m = new ModelAndView("AnimalList");
        m.addObject("animals", this.animalService.getAll().getData());
        return m;
    }

    @GetMapping("/getAllanimals")
    public ModelAndView getAllDeneme() {
        ModelAndView m = new ModelAndView("index");

        m.addObject("animals", this.animalService.getAll().getData());
        return m;
    }

    @GetMapping("/getByAnimalId")
    public ModelAndView getByAnimalId(@RequestParam int animalId) {
        ModelAndView m = new ModelAndView("index");

        m.addObject("animals", this.animalService.getByAnimalId(animalId).getData());
        return m;
    }

    @GetMapping("/deleteAnimal")
    public ModelAndView deleteAnimal(@RequestParam int animalId) {
        this.animalService.deleteByAnimalId(animalId);
        ModelAndView m = new ModelAndView("AnimalList");
        m.addObject("animals", this.animalService.getAll().getData());
        return m;
    }
    
    @GetMapping("/AddAnimal")
    public ModelAndView showAnimalAddPage(){
        Animal animal = new Animal();
        ModelAndView m = new ModelAndView("AddAnimal");
        m.addObject("animal",animal);
        return  m;
    }
    
    @PostMapping("/saveAnimal")
    public ModelAndView add(@ModelAttribute("animal") Animal animal ){
         animalService.add(animal);
         ModelAndView m = new ModelAndView("SuccessResultPage");
        return  m;
    }
}
