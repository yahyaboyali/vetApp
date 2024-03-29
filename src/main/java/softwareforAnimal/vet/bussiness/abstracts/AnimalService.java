/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareforAnimal.vet.bussiness.abstracts;

import java.util.List;
import softwareforAnimal.vet.core.utilities.results.DataResult;
import softwareforAnimal.vet.core.utilities.results.Result;
import softwareforAnimal.vet.entities.concretes.Animal;

/**
 *
 * @author yahya
 */
public interface AnimalService {

    DataResult<List<Animal>> getAll();
    
    DataResult<List<Animal>> getAll(int pageNo,int pageSize);
    
    DataResult<Animal> getByAnimalId(int animalId);
    
    String deleteByAnimalId(int animalId);
    
    Result add(Animal animal);
       
  //  Result updateAnimal(int animalId,String animalName,int personId,String explanation,int animalAge,String genus,String species);
    
}
