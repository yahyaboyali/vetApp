/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareforAnimal.vet.bussiness.abstracts;

import java.util.List;
import softwareforAnimal.vet.core.utilities.results.DataResult;
import softwareforAnimal.vet.entities.concretes.Animal;

/**
 *
 * @author yahya
 */
public interface AnimalService {

    DataResult<List<Animal>> getAll();
    
    DataResult<Animal> getByAnimalId(int animalId);
}
