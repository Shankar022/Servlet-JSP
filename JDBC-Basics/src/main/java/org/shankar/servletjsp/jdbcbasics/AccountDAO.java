package org.shankar.servletjsp.jdbcbasics;

import java.sql.*;

public class AccountDAO {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root12345");
            System.out.println(connection);
            Statement statement = connection.createStatement();
//            int executed = statement.executeUpdate("insert into account values (123, 'Shankar', 'Chakraborty', 10000)");
//            System.out.println(executed + " rows got affected");

            int executed = statement.executeUpdate("update account set bal=50000 where accno=123");
            System.out.println(executed + " rows got affected");
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        String url = "jdbc:mysql://localhost/mydb";
//        String username = "root";
//        String password = "root12345";
//
//        String insertQuery = "INSERT INTO account (id, first_name, last_name, balance) VALUES (?, ?, ?, ?)";
//
//        try (Connection connection = DriverManager.getConnection(url, username, password);
//             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
//
//            // Set parameters for the PreparedStatement
//            preparedStatement.setInt(1, 123);
//            preparedStatement.setString(2, "Shankar");
//            preparedStatement.setString(3, "Chakraborty");
//            preparedStatement.setDouble(4, 10000.00);
//
//            // Execute the query
//            int rowsAffected = preparedStatement.executeUpdate();
//            System.out.println(rowsAffected + " rows got affected");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
