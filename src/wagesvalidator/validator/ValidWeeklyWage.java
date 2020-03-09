/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wagesvalidator.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Muhammad Hussaini
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = WeeklyWageValidator.class)
public @interface ValidWeeklyWage {
    
    String message() default "{validweeklywage.constraint}";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload> [] payload() default {};
}
