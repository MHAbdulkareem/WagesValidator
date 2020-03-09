/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wagesvalidator;

import wagesvalidator.app.Frequency;
import wagesvalidator.app.Earning;
import wagesvalidator.app.RegularAmount;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author Muhammad Hussaini
 */
public class WagesValidator {

    /**
     * @param args the command line arguments
     * 
     * Earning Class contains a JSR-303 Annotated Instance of RegularAmount
     * This Class is Validated here!
     * Frequency and Amount can be changed to see validation message
     * 
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Earning earning = new Earning(new RegularAmount(Frequency.MONTH, 220.00));
        
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        
        Set<ConstraintViolation<Earning>> validate = validator.validate(earning);
        
        validate.forEach((violation) -> {
            RegularAmount wrongValue = (RegularAmount) violation.getInvalidValue();
            
            String message = violation.getMessage();
            System.out.println("Constraint violation for Amount: " + wrongValue.getAmount() + " Message: " + message );
        });
    }
    
}
