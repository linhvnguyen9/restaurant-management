package com.ptit.restaurantmanagement.dao;

import com.ptit.restaurantmanagement.database.RestaurantManagementDatabase;
import com.ptit.restaurantmanagement.domain.model.Customer;
import com.ptit.restaurantmanagement.domain.model.CustomerType;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CustomerDao {
    private Statement statement;
    private Connection stament = RestaurantManagementDatabase.getConnection();
    private PersonDao personDao = new PersonDao();
    ArrayList<Customer> listCustomer = new ArrayList<>();

    public CustomerDao() throws SQLException {
        RestaurantManagementDatabase.createDatabase(stament);
        RestaurantManagementDatabase.getConnection();
    }

    public int insertCustomer(Customer customer) throws SQLException {
        int personId = personDao.insertPerson(customer);

        String createCustomer = "INSERT INTO customer VALUES(?, ?)";

        PreparedStatement preparedStatement = stament.prepareStatement(createCustomer);
        preparedStatement.setInt(1, personId);
        preparedStatement.setString(2, customer.getCustomerType().toString());

        preparedStatement.executeUpdate();

        return personId;
    }

    public ArrayList<Customer> getListCustomer() {
        String sql = "SELECT * FROM person,customer WHERE id_person = id_customer;";

        try {
            PreparedStatement ps = stament.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_person");
                String name = (rs.getString("name"));

                Calendar dob = Calendar.getInstance();
                dob.setTime(rs.getDate("dob"));

                String phone = rs.getString("phone_number");

                String address = (rs.getString("addr"));
                CustomerType type;
                if (rs.getString("type").equals("NORMAL"))
                    type = CustomerType.NORMAL;
                else
                    type = CustomerType.VIP;
                Customer s = new Customer(id, name, dob, phone, address, type);
                listCustomer.add(s);

                for (int i = 0; i < listCustomer.size(); i++)
                    System.out.println(listCustomer.get(i).toString());

                return listCustomer;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //print out listEmployee
        for (int i=0;i<listCustomer.size();i++)
            System.out.println(listCustomer.get(i).toString());
        return new ArrayList<>();

    }

    public void updateCustomer(Customer customer, int id) throws SQLException {
        //update employee

        String updateEmployees = "UPDATE customer SET type=? WHERE id_customer=?;";
        PreparedStatement pstmt = stament.prepareStatement(updateEmployees);

        pstmt.setString(1, customer.getCustomerType().toString());
        pstmt.setInt(2, id);
        pstmt.executeUpdate();

        //update person
        String updatePerson = "UPDATE person SET name=?, dob=?, addr=? WHERE id_person=?;";
        PreparedStatement pstmt2 = stament.prepareStatement(updatePerson);

        pstmt2.setString(1, customer.getName());

        Date utilDate = customer.getDob().getTime();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());

        pstmt2.setDate(2, date);
        pstmt2.setString(3, customer.getAddress());
        pstmt2.setInt(4, id);

        System.out.println(pstmt2.toString());
        pstmt2.executeUpdate();

    }
    public void deleteCustomer(int id) throws SQLException {
        String delete = "delete from employee where id_employee=?;";
        PreparedStatement pstmCustomer = stament.prepareStatement(delete);
        pstmCustomer.setInt(1, id);
        pstmCustomer.executeUpdate();

        String deletePerson = "delete from person where id_person=?;";
        PreparedStatement pstmtPerson = stament.prepareStatement(deletePerson);
        pstmtPerson.setInt(1, id);
        pstmtPerson.executeUpdate();
    }

    public void searchListCustomer(String name) {
        for (int i = 0; i < listCustomer.size(); i++)
            if (listCustomer.get(i).getName().equals(name))
                System.out.println(listCustomer.get(i).toString());
    }
}