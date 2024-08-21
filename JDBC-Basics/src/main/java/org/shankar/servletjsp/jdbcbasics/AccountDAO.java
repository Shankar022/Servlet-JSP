package org.shankar.servletjsp.jdbcbasics;

import java.sql.*;


public class AccountDAO {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root12345");
            System.out.println(connection);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from account");
            while (resultSet.next()){
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // TODO : Use PreparedStatement and  Hikari Pool to poll the db connection
    }
}
