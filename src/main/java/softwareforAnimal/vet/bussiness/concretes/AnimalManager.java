/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareforAnimal.vet.bussiness.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softwareforAnimal.vet.bussiness.abstracts.AnimalService;
import softwareforAnimal.vet.core.utilities.results.DataResult;
import softwareforAnimal.vet.core.utilities.results.Result;
import softwareforAnimal.vet.core.utilities.results.SuccessDataResult;
import softwareforAnimal.vet.core.utilities.results.SuccessResult;
import softwareforAnimal.vet.dataAccess.abstracts.AnimalDao;
import softwareforAnimal.vet.entities.concretes.Animal;

/**
 *
 * @author yahya
 */
@Service
public class AnimalManager implements AnimalService{

    private AnimalDao animalDao;

    @Autowired
    public AnimalManager(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    @Override
    public DataResult<List<Animal>> getAll() {
        return new SuccessDataResult<List<Animal>> (this.animalDao.findAll(),"data listed");
    }


    @Override
    public DataResult<Animal> getByAnimalId(int animalId) {
        return new SuccessDataResult<Animal> (this.animalDao.getByAnimalId(animalId),"listed by animal id");
    }

    @Override
    public String deleteByAnimalId(int animalId) {
        this.animalDao.deleteById(animalId);
        return "deleted";
    }
    
}
