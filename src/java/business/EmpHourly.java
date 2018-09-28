/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;

/**
 *
 * @author fssco
 */
public class EmpHourly extends Person {

    private double rate;
    private double avgWeeklyHours;

    public EmpHourly() {
    }

    public EmpHourly(String firstName, String middleName, String lastName, int employeeID, 
            LocalDate birthDate, LocalDate hireDate, String type, double rate, double avgWeeklyHours) {
        super(employeeID, firstName, middleName, lastName, birthDate, hireDate, type);
        this.rate = rate;
        this.avgWeeklyHours = avgWeeklyHours;
    }

    //EDIT THIS
    @Override
    public String calcYearlyCompensation() {
        
        BigDecimal pay = (BigDecimal.valueOf(avgWeeklyHours).multiply(BigDecimal.valueOf(rate))).multiply(new BigDecimal(51));
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return nf.format(pay);
    }

    /**
     * @return the rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * @return the avgWeeklyHours
     */
    public double getAvgWeeklyHours() {
        return avgWeeklyHours;
    }

    /**
     * @param avgWeeklyHours the avgWeeklyHours to set
     */
    public void setAvgWeeklyHours(double avgWeeklyHours) {
        this.avgWeeklyHours = avgWeeklyHours;
    }

}
