
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
        String createEmployee = "INSERT INTO employee VALUES(?, ?, ?, ?)";

        PreparedStatement preparedStatement = stament.prepareStatement(createEmployee);

        int personId = personDao.insertPerson(employee);
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
                listEmployee.add(employeeFromResultSet(rs));
            }
            return listEmployee;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void updateEmployee(Employee employee, int id) throws SQLException {
        personDao.updatePerson(employee, id);

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
    }

    public void deleteEmployee(int id) throws SQLException {
        personDao.deletePerson(id);
    }

    public Employee getEmployeesById(int id) throws SQLException {
        String search = "select * from person,employee where id_person=id_employee and id_employee=?;";
        PreparedStatement pstmEmployee = stament.prepareStatement(search);
        pstmEmployee.setInt(1, id);

        ResultSet rs = pstmEmployee.executeQuery();
        rs.next();

        return employeeFromResultSet(rs);
    }

    public ArrayList<Employee> getEmployeesByName(String name) throws SQLException {
        String search = String.format("SELECT * FROM person,employee WHERE id_person=id_employee AND name LIKE '%%%s%%'", name);
        Statement statement = stament.createStatement();

        ResultSet rs = statement.executeQuery(search);

        ArrayList<Employee> result = new ArrayList<>();
        while (rs.next()) {
            result.add(employeeFromResultSet(rs));
        }

        return result;
    }

    private Employee employeeFromResultSet(ResultSet rs) throws SQLException {
        int employeeId = rs.getInt("id_person");
        String name = rs.getString("name");

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
