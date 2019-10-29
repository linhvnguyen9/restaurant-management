
package com.ptit.restaurantmanagement.dao;

import com.ptit.restaurantmanagement.database.RestaurantManagementDatabase;
import com.ptit.restaurantmanagement.domain.model.Employee;
import com.ptit.restaurantmanagement.domain.model.Person;

import java.sql.*;
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

        PreparedStatement preparedStatement = connection.prepareStatement(createPerson, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, employee.getName());

        Date utilDate = employee.getDob().getTime();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        preparedStatement.setDate(2, sqlDate);
        preparedStatement.setString(3, employee.getAddress());

        int personId = preparedStatement.executeUpdate();
        if (personId != -1) {
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                personId = resultSet.getInt(1);
            }
        } else {
            throw new SQLException();
        }

        String createEmployee = "INSERT INTO employee VALUES(?, ?, ?, ?)";

        preparedStatement = connection.prepareStatement(createEmployee);
        preparedStatement.setInt(1, personId);
        preparedStatement.setString(2, employee.getEmployeeType().toString());

        int employeeMamangerId = employee.getManagerId();
        if (employeeMamangerId == -1) {
            preparedStatement.setNull(3, Types.INTEGER);
        } else {
            preparedStatement.setInt(3, employeeMamangerId);
        }

        preparedStatement.setDouble(4, employee.getBaseSalary());

        preparedStatement.executeUpdate();

        return personId;
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
}
