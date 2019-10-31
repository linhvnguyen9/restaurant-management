package com.ptit.restaurantmanagement.dao;

import com.ptit.restaurantmanagement.database.RestaurantManagementDatabase;
import com.ptit.restaurantmanagement.domain.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class PersonDao {
    private Statement statement;
    private Connection connection = RestaurantManagementDatabase.getConnection();

    public PersonDao() throws SQLException {
        RestaurantManagementDatabase.createDatabase(connection);
        RestaurantManagementDatabase.getConnection();
    }

    int insertPerson(Person person) throws SQLException {
        String insertPerson = "INSERT INTO person VALUES(0, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(insertPerson, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, person.getName());

        Date utilDate = person.getDob().getTime();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        preparedStatement.setDate(2, sqlDate);
        preparedStatement.setString(3, person.getAddress());

        int personId = preparedStatement.executeUpdate();
        if (personId == 1) {
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                personId = resultSet.getInt(1);
            }
        } else {
            throw new SQLException();
        }

        return personId;
    }

    void updatePerson(Person person, int id) throws SQLException {
        String updatePerson = "UPDATE person SET name=?, dob=?, addr=? WHERE id_person=?";

        PreparedStatement preparedStatement = connection.prepareStatement(updatePerson);

        preparedStatement.setString(1, person.getName());

        Date utilDate = person.getDob().getTime();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        preparedStatement.setDate(2, sqlDate);
        preparedStatement.setString(3, person.getAddress());

        preparedStatement.setInt(4, id);

        preparedStatement.executeUpdate();
    }

    void deletePerson(int id) throws SQLException {
        String deletePerson = "delete from person where id_person=?;";
        PreparedStatement preparedStatement = connection.prepareStatement(deletePerson);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
