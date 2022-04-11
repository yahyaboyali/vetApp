/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareforAnimal.vet.api.controllers;

import io.swagger.models.Model;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import softwareforAnimal.vet.bussiness.abstracts.AnimalService;
import softwareforAnimal.vet.core.utilities.results.DataResult;
import softwareforAnimal.vet.core.utilities.results.ErrorDataResult;
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
        m.addObject("animals", this.animalService.getAll().getData());
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
    public ModelAndView showAnimalAddPage() {
        Animal animal = new Animal();
        ModelAndView m = new ModelAndView("AddAnimal");
        m.addObject("animal", animal);
        return m;
    }

    @PostMapping("/saveAnimal")
    public ModelAndView add(@ModelAttribute("animal") Animal animal) {
        animalService.add(animal);
        ModelAndView m = new ModelAndView("AnimalList");
        m.addObject("animals", this.animalService.getAll().getData());
        return m;
    }

    @GetMapping("/edit/{animalId}")
    public ModelAndView showUpdateForm(@PathVariable("animalId") int animalId) {
        Animal animal = animalService.getByAnimalId(animalId).getData();
        ModelAndView m = new ModelAndView("AnimalUpdate");
        m.addObject("animal", animal);
        return m;
    }

    @PostMapping("/update/{animalId}")
    public ModelAndView updateAnimal(@PathVariable("animalId") int animalId, @Valid Animal animal) {
        animalService.add(animal);
        ModelAndView m = new ModelAndView("AnimalList");
        m.addObject("animals", this.animalService.getAll().getData());
        return m;
    }

}
