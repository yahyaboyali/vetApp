/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareforAnimal.vet.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import softwareforAnimal.vet.core.utilities.entities.Person;

/**
 *
 * @author yahya
 */
public interface PersonDao extends JpaRepository<Person, Integer>{
    
}
