/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareforAnimal.vet.dataAccess.abstracts;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import softwareforAnimal.vet.entities.concretes.Animal;

/**
 *
 * @author yahya
 */
public interface AnimalDao extends JpaRepository<Animal, Integer>{
    /*
    update animal SET species='degisti',genus='degisti',animal_age=3,explanation='degismis', 
person_id=2, animal_name='degisti'
where animal_id=18
    */
//    @Modifying
//    @Query("update Animal a SET a.species= :species, a.genus=:genus,a.animalAge=:animalAge,"
//            + "a.explanation=:explanation,a.person.personId=:personId,a.animalName=:animalName Where a.animalId=:animalId")
//            @Transactional
//    void updateAnimal(@Param("animalId") int animalId, @Param("animalName") String animalName,
//            @Param("personId") int personId,
//            @Param("explanation") String explanation,@Param("animalAge")int animalAge,@Param("genus")String genus,
//            @Param("species")String species);
}
