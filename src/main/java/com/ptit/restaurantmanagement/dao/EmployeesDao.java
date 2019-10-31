
package com.ptit.restaurantmanagement.dao;

import com.ptit.restaurantmanagement.database.RestaurantManagementDatabase;
import com.ptit.restaurantmanagement.domain.model.Employee;
import com.ptit.restaurantmanagement.domain.model.EmployeeType;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class EmployeesDao {
    private Statement statement;
    private Connection stament = RestaurantManagementDatabase.getConnection();
    ArrayList<Employee> listEmployee = new ArrayList<>();

    public EmployeesDao() throws SQLException {
        RestaurantManagementDatabase.createDatabase(stament);
        RestaurantManagementDatabase.getConnection();
    }

    public int insertEmployee(Employee employee) throws SQLException {
        String createPerson = "INSERT INTO person VALUES (0, ?, ?, ?)";

        PreparedStatement preparedStatement = stament.prepareStatement(createPerson, Statement.RETURN_GENERATED_KEYS);
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

        preparedStatement = stament.prepareStatement(createEmployee);
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
        String sql = "SELECT * FROM testdb.person,testdb.employee WHERE id_person = id_employee;";

        try {
            PreparedStatement ps = stament.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee s = new Employee(sql);
                s.setId(rs.getInt("id_employee"));
                s.setName(rs.getString("name"));

                Calendar dob = Calendar.getInstance();
                dob.setTime(rs.getDate("dob"));

                s.setDob(dob);
                s.setAddress(rs.getString("addr"));
                if (rs.getString("type").equals("MANAGER"))
                    s.setEmployeeType(EmployeeType.MANAGER);
                else
                    s.setEmployeeType(EmployeeType.NORMAL);
                s.setManagerId(rs.getInt("id_manager"));
                s.setBaseSalary(rs.getDouble("salary"));
                listEmployee.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //print out listEmployee
        for (int i = 0; i < listEmployee.size(); i++)
            System.out.println(listEmployee.get(i).toString());
        return listEmployee;
    }

    public void updateEmployee(Employee employee, int id) throws SQLException {
        //update employee

        String updateEmployees = "UPDATE employee SET type=?,salary=? WHERE id_employee=?;";
        PreparedStatement pstmt = stament.prepareStatement(updateEmployees);

        pstmt.setString(1, employee.getEmployeeType().toString());

        //pstmt.setInt(2, employee.getManagerId());
        pstmt.setDouble(2, employee.getBaseSalary());
        pstmt.setInt(3, id);
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



        boolean autoCommit = stament.getAutoCommit();
        try {
            stament.setAutoCommit(false);

            stament.commit();
        } catch (SQLException exc) {
            stament.rollback();
        } finally {
            stament.setAutoCommit(autoCommit);
        }
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


    public void searchListEmployee(String name) {
        for (int i = 0; i < listEmployee.size(); i++)
            if (listEmployee.get(i).getName().equals(name))
                System.out.println(listEmployee.get(i).toString());
    }
}
