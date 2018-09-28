/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.text.NumberFormat;
import java.time.LocalDate;

/**
 *
 * @author fssco
 */
public class EmpSalary extends Person {

    private double salary;

    public EmpSalary() {
    }

    public EmpSalary(String firstName, String middleName, String lastName, int employeeID, 
            LocalDate birthDate, LocalDate hireDate, String type, double salary) {
        super(employeeID, firstName, middleName, lastName, birthDate, hireDate, type);
        this.salary = salary;
    }

    //EDIT THIS
    @Override
    public String calcYearlyCompensation() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return nf.format(salary);
    }

    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

}
