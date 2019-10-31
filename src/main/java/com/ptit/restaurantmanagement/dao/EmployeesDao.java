
package com.ptit.restaurantmanagement.dao;

import com.ptit.restaurantmanagement.database.RestaurantManagementDatabase;
import com.ptit.restaurantmanagement.domain.model.Employee;
import com.ptit.restaurantmanagement.domain.model.EmployeeType;
import com.ptit.restaurantmanagement.domain.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class EmployeesDao {
    private Statement statement;
    private Connection stament = RestaurantManagementDatabase.getConnection();
    private PersonDao personDao = new PersonDao();
    ArrayList<Employee> listEmployee = new ArrayList<>();

    public EmployeesDao() throws SQLException {
        RestaurantManagementDatabase.createDatabase(stament);
        RestaurantManagementDatabase.getConnection();
    }

    public int insertEmployee(Employee employee) throws SQLException {
        int personId = personDao.insertPerson(employee);

        String createEmployee = "INSERT INTO employee VALUES(?, ?, ?, ?)";

        PreparedStatement preparedStatement = stament.prepareStatement(createEmployee);
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

    public ArrayList<Employee> getListEmployee() {
        String sql = "SELECT * FROM person,employee WHERE id_person = id_employee;";

        try {
            PreparedStatement ps = stament.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = (rs.getInt("id_employee"));
                String name = (rs.getString("name"));

                Calendar dob = Calendar.getInstance();
                dob.setTime(rs.getDate("dob"));

                String address = (rs.getString("addr"));
                EmployeeType employeeType;
                if (rs.getString("type").equals("MANAGER")) {
                    employeeType = EmployeeType.MANAGER;
                }
                else {
                    employeeType = EmployeeType.NORMAL;
                }
                int managerId = rs.getInt("id_manager");
                double salary = rs.getDouble("salary");
                Employee s = new Employee(id, name, dob, address, employeeType, managerId, salary);
                listEmployee.add(s);
            }
            return listEmployee;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //print out listEmployee
//        for (int i = 0; i < listEmployee.size(); i++)
//            System.out.println(listEmployee.get(i).toString());
        return new ArrayList<>();
    }

    public void updateEmployee(Employee employee, int id) throws SQLException {
        String updateEmployees = "UPDATE employee SET type=?,id_manager = ?,salary=? WHERE id_employee=?;";
        PreparedStatement pstmt = stament.prepareStatement(updateEmployees);

        pstmt.setString(1, employee.getEmployeeType().toString());

        int employeeManagerId = employee.getManagerId();
        if (employeeManagerId == -1) {
            pstmt.setNull(2, Types.INTEGER);
        } else {
            pstmt.setInt(2, employeeManagerId);
        }

        pstmt.setDouble(3, employee.getBaseSalary());
        pstmt.setInt(4, id);
        System.out.println(pstmt.toString());
        pstmt.executeUpdate();

        //update person
        String updatePerson = "UPDATE person SET name=?, dob=?, addr=? WHERE id_person=?;";
        PreparedStatement pstmt2 = stament.prepareStatement(updatePerson);

        pstmt2.setString(1, employee.getName());

        Date utilDate = employee.getDob().getTime();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());

        pstmt2.setDate(2, date);
        pstmt2.setString(3, employee.getAddress());
        pstmt2.setInt(4, id);

        System.out.println(pstmt2.toString());
        pstmt2.executeUpdate();
    }

    public void deleteEmployee(int id) throws SQLException {
        String deleteEmployee = "delete from employee where id_employee=?;";
        PreparedStatement pstmEmployee = stament.prepareStatement(deleteEmployee);
        pstmEmployee.setInt(1, id);
        pstmEmployee.executeUpdate();

        String deletePerson = "delete from person where id_person=?;";
        PreparedStatement pstmtPerson = stament.prepareStatement(deletePerson);
        pstmtPerson.setInt(1, id);
        pstmtPerson.executeUpdate();
    }

    public Employee searchListEmployee(int id) throws SQLException {
        String search = "select * from person,employee where id_person=id_employee and id_employee=?;";
        PreparedStatement pstmEmployee = stament.prepareStatement(search);
        pstmEmployee.setInt(1, id);

        ResultSet rs = pstmEmployee.executeQuery();
        rs.next();

        int employeeId = (rs.getInt("id_person"));
        String name = (rs.getString("name"));

        Calendar dob = Calendar.getInstance();
        dob.setTime(rs.getDate("dob"));

        String address = (rs.getString("addr"));
        EmployeeType employeeType;
        if (rs.getString("type").equals("MANAGER")) {
            employeeType = EmployeeType.MANAGER;
        }
        else {
            employeeType = EmployeeType.NORMAL;
        }
        int managerId = rs.getInt("id_manager");
        double salary = rs.getDouble("salary");
        return new Employee(employeeId, name, dob, address, employeeType, managerId, salary);
    }
}
