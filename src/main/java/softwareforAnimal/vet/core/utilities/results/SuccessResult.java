/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareforAnimal.vet.core.utilities.results;

/**
 *
 * @author yahya
 */
public class SuccessResult extends Result{
     public SuccessResult() {
        super(true);
    }

    public SuccessResult( String message) {
        super(true, message);
    }
}
