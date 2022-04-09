/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareforAnimal.vet.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import softwareforAnimal.vet.entities.concretes.Animal;

/**
 *
 * @author yahya
 */
public interface AnimalDao extends JpaRepository<Animal, Integer>{
    
    
}
