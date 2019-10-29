
package com.ptit.restaurantmanagement.dao;

import com.ptit.restaurantmanagement.database.RestaurantManagementDatabase;
import com.ptit.restaurantmanagement.domain.model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

//    public int insertEmployee(int id,String name,Date dob,String addr,EmployeeType type,double salary) throws SQLException {
//        String query = "INSERT INTO employees(name, position, salary)";
//        String values = String.format(" VALUES('%s', '%s', %f)", name, position, salary);
//
//        int rowAffected = statement.executeUpdate(query + values, Statement.RETURN_GENERATED_KEYS);
//        if (rowAffected == 1) {
//            ResultSet rs = statement.getGeneratedKeys();
//            if (rs.next())
//                return rs.getInt(1);
//        }
//        return -1;
//    }
    
    public int insertEmployee(Employee employee) throws SQLException {
        String query = "INSERT INTO employees(id,name,dob,addr,type,id_manager,salary)";
        String values = String.format(" VALUES(?,?)",employee.getId(), employee.getName(),
                employee.getDob(),employee.getAddress(),employee.getEmployeeType().toString(),employee.getManagerId(),employee.getSalaryByMonth(5, 6));
        
        int rowAffected = statement.executeUpdate(query + values, Statement.RETURN_GENERATED_KEYS);
        if (rowAffected == 1) {
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next())
                return rs.getInt(1);
        }
        return -1;
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
