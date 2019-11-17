
package com.ptit.restaurantmanagement.dao;

import com.ptit.restaurantmanagement.database.RestaurantManagementDatabase;
import com.ptit.restaurantmanagement.database.dto.CustomerIdAndInvoiceSumDto;
import com.ptit.restaurantmanagement.domain.model.Customer;
import com.ptit.restaurantmanagement.domain.model.CustomerType;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

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
        String createCustomer = "INSERT INTO customer VALUES(?, ?);";

        PreparedStatement preparedStatement = stament.prepareStatement(createCustomer);

        int personId = personDao.insertPerson(customer);

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
                listCustomer.add(CustomerFromResultSet(rs));
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
        return new ArrayList<>();
    }

    public void updateCustomer(Customer customer, int id) throws SQLException {
        personDao.updatePerson(customer, id);

        String updateCustomer = "UPDATE customer SET type=? WHERE id_customer=?;";
        PreparedStatement pstmt = stament.prepareStatement(updateCustomer);

        pstmt.setString(1, customer.getCustomerType().toString());
        pstmt.setInt(2, id);
        pstmt.executeUpdate();
    }

    public void deleteCustomer(int id) throws SQLException {
        personDao.deletePerson(id);
    }

    public Customer getCustomerById(int id) throws SQLException {
        String search = "select * from person,customer where id_person=id_customer and id_customer=?;";
        PreparedStatement pstmCustomer = stament.prepareStatement(search);
        pstmCustomer.setInt(1, id);

        ResultSet rs = pstmCustomer.executeQuery();
        rs.next();

        return CustomerFromResultSet(rs);
    }

    public ArrayList<Customer> getCustomerByName(String name) throws SQLException {
        String search = String.format("SELECT * FROM person,customer WHERE id_person=id_customer AND name LIKE '%%%s%%'", name);
        Statement statement = stament.createStatement();

        ResultSet rs = statement.executeQuery(search);

        ArrayList<Customer> result = new ArrayList<>();
        while (rs.next()) {
            result.add(CustomerFromResultSet(rs));
        }

        return result;
    }

    private Customer CustomerFromResultSet(ResultSet rs) throws SQLException {
        int customerId = rs.getInt("id_person");
        String name = rs.getString("name");

        Calendar dob = Calendar.getInstance();
        dob.setTime(rs.getDate("dob"));

        String address = (rs.getString("addr"));
        String phoneNumber = rs.getString("phone_number");
        CustomerType customerType;
        if (rs.getString("type").equals("VIP")) {
            customerType = CustomerType.VIP;
        } else {
            customerType = CustomerType.NORMAL;
        }
        return new Customer(customerId, name, dob, address, phoneNumber, customerType);
    }

    public ArrayList<CustomerIdAndInvoiceSumDto> displayCustomerTotalAmountPurchased() throws SQLException {
        String query = "SELECT id_customer, name, SUM(total) " +
                        "FROM " +
                            "((SELECT customer.id_customer, person.name, invoice.id_invoice, SUM(quantity*price) " +
                            "as total " +
                            "FROM customer, invoice, line, menu_entry, person " +
                            "WHERE (invoice.id_customer = customer.id_customer " +
                                "AND line.id_invoice = invoice.id_invoice " +
                                "AND menu_entry.id_menu_entry = line.id_menu_entry " +
                                "AND person.id_person = customer.id_customer) " +
                            "GROUP BY invoice.id_invoice) as totalbill) " +
                        "GROUP BY id_customer;";

        Statement stmt = stament.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<CustomerIdAndInvoiceSumDto> result = new ArrayList<>();

        while (rs.next()) {
            int customerId = rs.getInt(1);
            String customerName = rs.getString(2);
            int sum = rs.getInt(3);

            CustomerIdAndInvoiceSumDto temp = new CustomerIdAndInvoiceSumDto(customerId, customerName, sum);
            System.out.println(temp);
            result.add(temp);
        }

        return result;
    }

    public void updateVipCustomers() throws SQLException {
        String query = "SET SQL_SAFE_UPDATES = 0";
        Statement stmt = stament.createStatement();
        stmt.executeQuery(query);

        query = "UPDATE customer SET customer.type = 'VIP' WHERE customer.id_customer IN (SELECT id_customer FROM ((SELECT id_customer, name, SUM(total) as total2 FROM ((SELECT customer.id_customer, person.name, invoice.id_invoice, SUM(quantity*price) as total FROM customer, invoice, line, menu_entry, person WHERE (invoice.id_customer = customer.id_customer AND line.id_invoice = invoice.id_invoice AND menu_entry.id_menu_entry = line.id_menu_entry AND person.id_person = customer.id_customer) GROUP BY invoice.id_invoice) as totalbill) GROUP BY id_customer) as report) WHERE total2>1000000)";

        stmt.executeUpdate(query);
    }
}