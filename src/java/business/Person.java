/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.time.LocalDate;

/**
 *
 * @author fssco
 */
public class Person {

    private String firstName;
    private String middleName;
    private String lastName;
    private int employeeID;
    private LocalDate birthDate;
    private LocalDate hireDate;
    private String type;

    public Person() {
    }

    public Person(int employeeID, String firstName, String middleName, String lastName, LocalDate birthDate, LocalDate hireDate, String type) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.employeeID = employeeID;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.type = type;
    }

    public String calcYearlyCompensation() {
        return "None";
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the employeeID
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * @param employeeID the employeeID to set
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * @return the birthDate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the hireDate
     */
    public LocalDate getHireDate() {
        return hireDate;
    }

    /**
     * @param hireDate the hireDate to set
     */
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package business;
//
//import java.io.Serializable;
//import java.time.LocalDate;
//
///**
// *
// * @author fssco
// */
//public class Person implements Serializable{
//    private int employeeID;
//    private String firstName;
//    private String middleName;
//    private String lastName;
//    
//    private LocalDate birthDate;
//    private LocalDate hireDate;
//
//    public Person () {};
//    
//    public Person (int employeeID, String firstName, String middleName, String lastName, LocalDate birthDate, LocalDate hireDate) {
//        this.employeeID=employeeID;
//        this.firstName=firstName;
//        this.middleName=middleName;
//        this.lastName=lastName;
//        
//        this.birthDate=birthDate;
//        this.hireDate=hireDate;
//    }
//    /**
//     * @return the firstName
//     */
//    public String getFirstName() {
//        return firstName;
//    }
//
//    /**
//     * @param firstName the firstName to set
//     */
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    /**
//     * @return the middleName
//     */
//    public String getMiddleName() {
//        return middleName;
//    }
//
//    /**
//     * @param middleName the middleName to set
//     */
//    public void setMiddleName(String middleName) {
//        this.middleName = middleName;
//    }
//
//    /**
//     * @return the lastName
//     */
//    public String getLastName() {
//        return lastName;
//    }
//
//    /**
//     * @param lastName the lastName to set
//     */
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    /**
//     * @return the employeeID
//     */
//    public int getEmployeeID() {
//        return employeeID;
//    }
//
//    /**
//     * @param employeeID the employeeID to set
//     */
//    public void setEmployeeID(int employeeID) {
//        this.employeeID = employeeID;
//    }
//
//    /**
//     * @return the birthDate
//     */
//    public LocalDate getBirthDate() {
//        return birthDate;
//    }
//
//    /**
//     * @param birthDate the birthDate to set
//     */
//    public void setBirthDate(LocalDate birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    /**
//     * @return the hireDate
//     */
//    public LocalDate getHireDate() {
//        return hireDate;
//    }
//
//    /**
//     * @param hireDate the hireDate to set
//     */
//    public void setHireDate(LocalDate hireDate) {
//        this.hireDate = hireDate;
//    }
//    
//}
