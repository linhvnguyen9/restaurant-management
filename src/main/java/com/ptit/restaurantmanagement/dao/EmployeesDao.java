
package com.ptit.restaurantmanagement.dao;

import com.ptit.restaurantmanagement.database.RestaurantManagementDatabase;
import com.ptit.restaurantmanagement.domain.model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class EmployeesDao {
    private Statement statement;
    private Connection connection = RestaurantManagementDatabase.getConnection();

    public EmployeesDao() throws SQLException {
         RestaurantManagementDatabase.createDatabase(connection);
         RestaurantManagementDatabase.getConnection();
    }

    public int insertEmployee(Employee employee) throws SQLException {
        String createPerson = "INSERT INTO person VALUES (0, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(createPerson);
        preparedStatement.setString(1, employee.getName());

        Date utilDate = employee.getDob().getTime();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        preparedStatement.setDate(2, sqlDate);
        preparedStatement.setString(3, employee.getAddress());

        int employeeId = preparedStatement.executeUpdate(createPerson, Statement.RETURN_GENERATED_KEYS);
        if (employeeId != -1) {
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                employeeId = resultSet.getInt(1);
            }
        } else {
            throw new SQLException();
        }

        String createEmployee = "INSERT INTO employee VALUES(?, ?, ?, ?)";

        preparedStatement = connection.prepareStatement(createEmployee);
        preparedStatement.setInt(1, employeeId);
        preparedStatement.setString(2, employee.getEmployeeType().toString());
        preparedStatement.setDouble(3, employee.getBaseSalary());

        preparedStatement.executeUpdate(createEmployee);

        return employeeId;
    }
//    public int updateEmployee(int id) {
//        return connection.update(
//                "UPDATE employee  SET name=?, dob=?, addr=?, type='?, where id = ? limit 1;",name,dob,addr,type,id);
//    }
     public ArrayList<Person> getListPersons(){
        ArrayList<Person> list = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Person s=new Person(sql);
                s.setId(rs.getInt("ID"));
                s.setName(rs.getString("name"));
                
                Calendar dob = Calendar.getInstance();
                dob.setTime(rs.getDate("dob"));
                
                s.setDob(dob);
                s.setAddress(rs.getString("address"));                              
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
     
     public static void main(String[] args)  throws SQLException{
         Employee employee = new Employee(1,"Hello", Calendar.getInstance(), "Hanoi", EmployeeType.NORMAL, null, 100.0);
         
    }
    
}
