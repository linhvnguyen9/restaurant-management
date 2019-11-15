package com.ptit.restaurantmanagement.dao;

import com.ptit.restaurantmanagement.database.RestaurantManagementDatabase;
import com.ptit.restaurantmanagement.domain.model.Line;

import java.sql.*;
import java.util.ArrayList;

public class LineDao {
    private Statement statement;
    private Connection stament = RestaurantManagementDatabase.getConnection();
    ArrayList<Line> listLine = new ArrayList<>();

    public LineDao() throws SQLException {
        RestaurantManagementDatabase.createDatabase(stament);
        RestaurantManagementDatabase.getConnection();
    }

    public void insertLine(Line line) throws SQLException {
        String insertLine = "INSERT INTO line VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = stament.prepareStatement(insertLine, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, line.getInvoiceId());
        preparedStatement.setInt(2, line.getEntryId());
        preparedStatement.setInt(3, line.getQuantity());

        preparedStatement.executeUpdate();
//        if (lineId != -1) {
//            ResultSet resultSet = preparedStatement.getGeneratedKeys();
//            if (resultSet.next()) {
//                lineId = resultSet.getInt(1);
//            }
//        } else {
//            throw new SQLException();
//        }
    }

    public ArrayList<Line> getListLine() {
        String sql = "SELECT * FROM line;";

        try {
            PreparedStatement ps = stament.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_invoice = (rs.getInt("id_invoice"));
                int id_menu_entry = (rs.getInt("id_menu_entry"));
                int quantity = rs.getInt("quantity");
                Line s=new Line(id_invoice,id_menu_entry,quantity);
                listLine.add(s);
            }
            for (int i = 0; i < listLine.size(); i++)
                System.out.println(listLine.get(i).toString());
            return listLine;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    public void updateLine(Line line, int id_invoice) throws SQLException {
        String updateEmployees = "UPDATE line SET quantity=? WHERE id_invoice=?;";
        PreparedStatement pstmt = stament.prepareStatement(updateEmployees);

        pstmt.setInt(1,line.getQuantity() );
        pstmt.setInt(2,id_invoice);
        System.out.println(pstmt.toString());
        pstmt.executeUpdate();
    }

    public void deleteLine(int id_invoice) throws SQLException {
        String deleteLine = "delete from line where id_invoice=?;";
        PreparedStatement pstmline = stament.prepareStatement(deleteLine);
        pstmline.setInt(1, id_invoice);
        pstmline.executeUpdate();
    }
}
