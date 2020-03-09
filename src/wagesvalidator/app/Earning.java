/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wagesvalidator.app;

import wagesvalidator.validator.ValidWeeklyWage;

/**
 *
 * @author Muhammad Hussaini
 */
public class Earning {
    
    @ValidWeeklyWage(message = "Invalid Weekly Wage")
    private RegularAmount regularAmount;

    public Earning(RegularAmount regularAmount) {
        this.regularAmount = regularAmount;        
    }

    public RegularAmount getRegularAmount() {
        return regularAmount;
    }

    public void setRegularAmount(RegularAmount regularAmount) {
        this.regularAmount = regularAmount;
    }
    
}
