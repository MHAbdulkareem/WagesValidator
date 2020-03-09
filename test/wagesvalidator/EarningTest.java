/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wagesvalidator;

import wagesvalidator.app.RegularAmount;
import wagesvalidator.app.Frequency;
import wagesvalidator.app.Earning;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Muhammad Hussaini
 */
public class EarningTest {
    
    /*
        Two Tests validating the output of the WagesValidator on Weekly Wages.
    */
    
    @Test
    public void whenValidWeeklyAmountThenNoError() {
        // Valid Weekly Pay Test
        Earning earning = new Earning(new RegularAmount(Frequency.WEEK, 50.00));
        
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        
        Set<ConstraintViolation<Earning>> validation = validator.validate(earning);
        
        validation.forEach((violation) -> {
            RegularAmount wrongValue = (RegularAmount) violation.getInvalidValue();
            
            String message = violation.getMessage();
            System.out.println("Constraint violation for Amount: " + wrongValue.getAmount() + " Message: " + message );
            
            assertNull("No message expected for valid weekly wage", message);
        });
    }
    
    @Test
    public void whenInvalidWeekAmountThenShowError() {
        // Invalid Weekly Pay Test
        
        final String errorMsg = "Invalid Weekly Wage";
        
        Earning earning = new Earning(new RegularAmount(Frequency.WEEK, 48.43));
        
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        
        Set<ConstraintViolation<Earning>> validation = validator.validate(earning);
        
        validation.forEach((violation) -> {
            RegularAmount wrongValue = (RegularAmount) violation.getInvalidValue();
            
            String message = violation.getMessage();
            System.out.println("Constraint violation for Amount: " + wrongValue.getAmount() + " Message: " + message );
            
            assertEquals("Valid error message expected for Invalid weekly wage", errorMsg, message);
        });
    }
    
}
