package org.shankar.servletjsp.jdbcbasics;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AccountDAO {
    private static final Logger logger = LoggerFactory.getLogger(AccountDAO.class);

//    public static void main(String[] args) {
//        try (
//                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root12345");
//                Statement statement = connection.createStatement();
//                ResultSet resultSet = statement.executeQuery("select * from account");
//        ) {
//
//            while (resultSet.next()) {
//                logger.info("Full name : {} {}, Balance : {}", resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
//            }
//        } catch (SQLException e) {
//            logger.error(e.getLocalizedMessage());
//        }
//    }

    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost/mydb");
        config.setUsername("root");
        config.setPassword("root12345");
        config.setConnectionTimeout(30000);
        config.setIdleTimeout(60000);
        config.setMaximumPoolSize(10);
        dataSource = new HikariDataSource(config);
    }

    public static void main(String[] args) {
        String query = "SELECT accno, firstname, lastname, bal FROM account";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                String firstName = resultSet.getString(2);  // first_name
                String lastName = resultSet.getString(3);  // last_name
                int balance = resultSet.getInt(4);
                logger.info("Full name : {} {}, Balance : {}", firstName, lastName, balance);// balance
            }
        } catch (SQLException e) {
            logger.error(e.getLocalizedMessage());
        }
    }
}

