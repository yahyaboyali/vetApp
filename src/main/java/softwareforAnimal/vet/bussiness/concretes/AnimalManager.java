/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareforAnimal.vet.bussiness.concretes;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import softwareforAnimal.vet.bussiness.abstracts.AnimalService;
import softwareforAnimal.vet.core.utilities.results.DataResult;
import softwareforAnimal.vet.core.utilities.results.ErrorDataResult;
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
        if(this.animalDao.existsById(animalId)){
            return new SuccessDataResult<Animal> (this.animalDao.getById(animalId),"listed by animal id");
        }
        else{
            return new ErrorDataResult("data not found");
        }
    }

    @Override
    public String deleteByAnimalId(int animalId) {
        this.animalDao.deleteById(animalId);
        return "deleted";
    }

    @Override
    public Result add(Animal animal) {
        this.animalDao.save(animal);
        return new SuccessDataResult("added");
    }

//    @Override
//    public Result updateAnimal(int animalId, String animalName, int personId, String explanation, int animalAge, String genus, String species) {
//        this.animalDao.updateAnimal(animalId, animalName, personId, explanation, animalAge, genus, species);
//        return new SuccessDataResult("updated");
//    }

    @Override
    public DataResult<List<Animal>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize); 
        return new SuccessDataResult<List<Animal>>(this.animalDao.findAll(pageable).getContent(),"listed by pageable");
    }
    
}
