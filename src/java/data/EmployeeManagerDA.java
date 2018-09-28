/* 
 *   Document   : EmployeeManagerDA
 *   Created on : Aug 15, 2018, 10:03:21 PM
 *   Author     : lwetz
 */
package data;

import business.EmpHourly;
import business.EmpSalary;
import business.Person;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author fssco
 */
public class EmployeeManagerDA {

    public static ArrayList<Person> getAllEmployees() {
        ArrayList<Person> allEmps = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Persons "
                + "ORDER BY EmployeeID";
        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                switch (rs.getString("EmployeeType")) {
                    case "Hourly":
                        EmpHourly hourly = new EmpHourly();
                        hourly.setEmployeeID(rs.getInt("EmployeeID"));
                        hourly.setFirstName(rs.getString("FirstName"));
                        if (rs.getString("MiddleName") == null) {
                            hourly.setMiddleName("");
                        } else {
                            hourly.setMiddleName(rs.getString("MiddleName"));
                        }
                        hourly.setLastName(rs.getString("LastName"));
                        //taken from https://stackoverflow.com/questions/29168494/how-to-convert-localdate-to-sql-date-java
                        hourly.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                        hourly.setHireDate(rs.getDate("HireDate").toLocalDate());
                        hourly.setType(rs.getString("EmployeeType"));
                        hourly.setRate(rs.getDouble("Rate"));
                        hourly.setAvgWeeklyHours(rs.getDouble("avgWeeklyHours"));
                        allEmps.add(hourly);
                        break;
                    case "Salary":
                        EmpSalary salary = new EmpSalary();
                        salary.setEmployeeID(rs.getInt("EmployeeID"));
                        salary.setFirstName(rs.getString("FirstName"));
                        if (rs.getString("MiddleName") == null) {
                            salary.setMiddleName("");
                        } else {
                            salary.setMiddleName(rs.getString("MiddleName"));
                        }
                        salary.setLastName(rs.getString("LastName"));
                        salary.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                        salary.setHireDate(rs.getDate("HireDate").toLocalDate());
                        salary.setType(rs.getString("EmployeeType"));
                        salary.setSalary(rs.getDouble("Salary"));
                        allEmps.add(salary);
                        break;
                    default:
                        Person person = new Person();
                        person.setEmployeeID(rs.getInt("EmployeeID"));
                        person.setFirstName(rs.getString("FirstName"));
                        if (rs.getString("MiddleName") == null) {
                            person.setMiddleName("");
                        } else {
                            person.setMiddleName(rs.getString("MiddleName"));
                        }
                        person.setLastName(rs.getString("LastName"));
                        person.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                        person.setHireDate(rs.getDate("HireDate").toLocalDate());
                        person.setType(rs.getString("EmployeeType"));
                        allEmps.add(person);
                        break;
                }

            }
            return allEmps;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static boolean selectSingleEmployee(int empID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean answer = true;

        String query = "SELECT * FROM Persons "
                + "WHERE EmployeeID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, empID);
            rs = ps.executeQuery();
            if (rs.next()) {
                answer = true;
            } else {
                answer = false;
            }
//            Person person = null;
//            if (rs.next()) {
//                person = new Person();
//                person.setEmployeeID(rs.getInt("EmployeeID"));
//                person.setFirstName(rs.getString("FirstName"));
//                if (rs.getString("MiddleName") == null) {
//                    person.setMiddleName("");
//                } else {
//                    person.setMiddleName(rs.getString("MiddleName"));
//                }
//                person.setLastName(rs.getString("LastName"));
//                //taken from https://stackoverflow.com/questions/29168494/how-to-convert-localdate-to-sql-date-java
//                person.setBirthDate(rs.getDate("BirthDate").toLocalDate());
//                person.setHireDate(rs.getDate("HireDate").toLocalDate());
//            }
            return answer;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int insertHourly(EmpHourly person) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO Persons (EmployeeID, FirstName, MiddleName,LastName,BirthDate,HireDate,Salary,Rate,AvgWeeklyHours,EmployeeType) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            if (person.getEmployeeID() != 0) {
                ps.setInt(1, person.getEmployeeID());
            } else {
                ps.setNull(1, Types.INTEGER);
            }
            ps.setString(2, person.getFirstName());
            ps.setString(3, person.getMiddleName());
            ps.setString(4, person.getLastName());
            //taken from https://stackoverflow.com/questions/29168494/how-to-convert-localdate-to-sql-date-java
            ps.setDate(5, Date.valueOf(person.getBirthDate()));
            ps.setDate(6, Date.valueOf(person.getHireDate()));
            ps.setNull(7, Types.DOUBLE);
            ps.setDouble(8, person.getRate());
            ps.setDouble(9, person.getRate());
            ps.setString(10, person.getType());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            return generatedKey;
        } catch (SQLException e) {
            //need something for exception
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int insertSalary(EmpSalary person) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO Persons (EmployeeID, FirstName, MiddleName,LastName,BirthDate,HireDate,Salary,Rate,AvgWeeklyHours,EmployeeType) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            if (person.getEmployeeID() != 0) {
                ps.setInt(1, person.getEmployeeID());
            } else {
                ps.setNull(1, Types.INTEGER);
            }
            ps.setString(2, person.getFirstName());
            ps.setString(3, person.getMiddleName());
            ps.setString(4, person.getLastName());
            //taken from https://stackoverflow.com/questions/29168494/how-to-convert-localdate-to-sql-date-java
            ps.setDate(5, Date.valueOf(person.getBirthDate()));
            ps.setDate(6, Date.valueOf(person.getHireDate()));
            ps.setDouble(7, person.getSalary());
            ps.setNull(8, Types.DOUBLE);
            ps.setNull(9, Types.DOUBLE);
            ps.setString(10, person.getType());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            return generatedKey;
        } catch (SQLException e) {
            //need something for exception
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int insertEmployee(Person person) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query
                = "INSERT INTO Persons (EmployeeID, FirstName, MiddleName,LastName,BirthDate,HireDate,Salary,Rate,AvgWeeklyHours,EmployeeType) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            if (person.getEmployeeID() != 0) {
                ps.setInt(1, person.getEmployeeID());
            } else {
                ps.setNull(1, Types.INTEGER);
            }
            ps.setString(2, person.getFirstName());
            ps.setString(3, person.getMiddleName());
            ps.setString(4, person.getLastName());
            //taken from https://stackoverflow.com/questions/29168494/how-to-convert-localdate-to-sql-date-java
            ps.setDate(5, Date.valueOf(person.getBirthDate()));
            ps.setDate(6, Date.valueOf(person.getHireDate()));
            ps.setNull(7, Types.DOUBLE);
            ps.setNull(8, Types.DOUBLE);
            ps.setNull(9, Types.DOUBLE);
            ps.setString(10, person.getType());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            return generatedKey;
        } catch (SQLException e) {
            //need something for exception
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<Person> searchEmployees(LocalDate searchDate, String searchValue) {
        ArrayList<Person> allEmps = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = null;
        if (searchValue.equals("before")) {
            query = "SELECT * FROM Persons "
                    + "WHERE HireDate <= ?";
        } else {
            query = "SELECT * FROM Persons "
                    + "WHERE HireDate >= ?";
        }
        try {
            ps = connection.prepareStatement(query);
            ps.setDate(1, Date.valueOf(searchDate));
            rs = ps.executeQuery();
            while (rs.next()) {
                switch (rs.getString("EmployeeType")) {
                    case "Hourly":
                        EmpHourly hourly = new EmpHourly();
                        hourly.setEmployeeID(rs.getInt("EmployeeID"));
                        hourly.setFirstName(rs.getString("FirstName"));
                        if (rs.getString("MiddleName") == null) {
                            hourly.setMiddleName("");
                        } else {
                            hourly.setMiddleName(rs.getString("MiddleName"));
                        }
                        hourly.setLastName(rs.getString("LastName"));
                        hourly.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                        hourly.setHireDate(rs.getDate("HireDate").toLocalDate());
                        hourly.setType(rs.getString("EmployeeType"));
                        hourly.setRate(rs.getDouble("Rate"));
                        hourly.setAvgWeeklyHours(rs.getDouble("avgWeeklyHours"));
                        allEmps.add(hourly);
                        break;
                    case "Salary":
                        EmpSalary salary = new EmpSalary();
                        salary.setEmployeeID(rs.getInt("EmployeeID"));
                        salary.setFirstName(rs.getString("FirstName"));
                        if (rs.getString("MiddleName") == null) {
                            salary.setMiddleName("");
                        } else {
                            salary.setMiddleName(rs.getString("MiddleName"));
                        }
                        salary.setLastName(rs.getString("LastName"));
                        salary.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                        salary.setHireDate(rs.getDate("HireDate").toLocalDate());
                        salary.setType(rs.getString("EmployeeType"));
                        salary.setSalary(rs.getDouble("Salary"));
                        allEmps.add(salary);
                        break;
                    default:
                        Person person = new Person();
                        person.setEmployeeID(rs.getInt("EmployeeID"));
                        person.setFirstName(rs.getString("FirstName"));
                        if (rs.getString("MiddleName") == null) {
                            person.setMiddleName("");
                        } else {
                            person.setMiddleName(rs.getString("MiddleName"));
                        }
                        person.setLastName(rs.getString("LastName"));
                        person.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                        person.setHireDate(rs.getDate("HireDate").toLocalDate());
                        person.setType(rs.getString("EmployeeType"));
                        allEmps.add(person);
                        break;
                }
            }
            return allEmps;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int deleteUser(int empID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "DELETE FROM Persons "
                + "WHERE EmployeeID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, empID);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

//    public static void insertPrevious() {
//        ArrayList<Person> all = getOldEmps(); //gets all of the employees from the other method
//        for (Person p : all) {
//            insertEmployee(p);
//        }
//    }
//    public static ArrayList<Person> getOldEmps() {
//        ArrayList<Person> all = new ArrayList<>();
//        all.add(new Person(65, "Aaron", "A", "Aaronson",
//                LocalDate.of(1980, Month.JANUARY, 1), LocalDate.of(2013, Month.JANUARY, 2)));
//
//        all.add(new Person(66, "Erin", "E", "Erinson",
//                LocalDate.of(1980, Month.JANUARY, 1), LocalDate.of(2012, Month.JANUARY, 1)));
//
//        all.add(new Person(1313, "Beatrix", "", "Kiddo",
//                LocalDate.of(1976, Month.FEBRUARY, 28), LocalDate.of(2003, Month.OCTOBER, 10)));
//
//        all.add(new Person(2000, "Paul", "Muad'Dib", "Atreides",
//                LocalDate.of(1965, Month.APRIL, 4), LocalDate.of(1984, Month.MAY, 5)));
//
//        all.add(new Person(1985, "Marty", "", "McFly",
//                LocalDate.of(1968, Month.JUNE, 12), LocalDate.of(1885, Month.JANUARY, 1)));
//
//        all.add(new Person(734, "Roy", "", "Batty",
//                LocalDate.of(2016, Month.JANUARY, 8), LocalDate.of(2016, Month.JANUARY, 9)));
//
//        all.add(new Person(1337, "Molly", "", "Millions",
//                LocalDate.of(1984, Month.JULY, 1), LocalDate.of(2000, Month.APRIL, 18)));
//
//        all.add(new Person(37, "Loren", "R", "Wetzel",
//                LocalDate.of(1981, Month.AUGUST, 9), LocalDate.of(1999, Month.AUGUST, 1)));
//
//        all.add(new Person(16, "Romeo", "R", "Wetzel",
//                LocalDate.of(2002, Month.APRIL, 25), LocalDate.of(2010, Month.APRIL, 30)));
//
//        all.add(new Person(3, "Ashton", "M", "Wetzel",
//                LocalDate.of(2015, Month.FEBRUARY, 14), LocalDate.of(2018, Month.FEBRUARY, 26)));
//
//        return all;
//    }
}
