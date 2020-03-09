/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wagesvalidator.app;


/**
 *
 * @author
 */
public class RegularAmount {
    private Frequency frequency;
    private Double amount;

    public RegularAmount(Frequency frequency, Double amount) {
        this.frequency = frequency;
        this.amount = amount;
    }

    public RegularAmount() {
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
}
