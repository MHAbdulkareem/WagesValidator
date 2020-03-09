/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wagesvalidator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import wagesvalidator.app.Frequency;
import wagesvalidator.app.RegularAmount;

/**
 *
 * @author Muhammad Hussaini
 */
public class WeeklyWageValidator implements ConstraintValidator<ValidWeeklyWage, RegularAmount> {

    @Override
    public boolean isValid(RegularAmount amount, ConstraintValidatorContext cv) {
        
        boolean result = false;
        
        if (amount != null) {
            
            Frequency frequency = amount.getFrequency();
            Double wageAmount = amount.getAmount();
            
            switch (frequency) {
                case WEEK:
                    if (isValidWage(wageAmount)) {
                        result = true;
                    }
                    break;
                case TWO_WEEK:
                    Double biWeeklyWage = wageAmount / 2;
                    if(isValidWage(biWeeklyWage)) {
                        return true;
                    }
                    break;
                case FOUR_WEEK:
                    Double fourWeeklyWage = wageAmount / 4;
                    if (isValidWage(fourWeeklyWage)) {
                        result = true;
                    }
                    break;
                case MONTH:
                    Double monthlyWage = wageAmount / 4;
                    if (isValidWage(monthlyWage)) {
                        result = true;
                    }
                    break;
                case QUARTER:
                    Double quarterlyWage = wageAmount / 13;
                    if (isValidWage(quarterlyWage)) {
                        result = true;
                    }
                    break;
                case YEAR:
                    Double yearlyWage = wageAmount / 52;
                    if (isValidWage(yearlyWage)) {
                        result = true;
                    }
                    break;
            }
        }
        return result;
    }

    // Return true is wage is divisible without a remainder
    private boolean isValidWage(double d) {
        return (d % 1) == 0;
    }

}
