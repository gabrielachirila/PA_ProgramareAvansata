package org.example;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/albums";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";

    private static DataSource dataSource = null;

    private Database() {}

    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            setupDataSource();
        }
        return dataSource.getConnection();
    }

    private static void setupDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(URL);
        ds.setUsername(USER);
        ds.setPassword(PASSWORD);
        ds.setInitialSize(5);
        ds.setMaxActive(10);
        ds.setMaxIdle(5);
        ds.setMinIdle(2);
        dataSource = ds;
    }

    public static void closeConnection() throws SQLException {
        if (getConnection() != null) {
            getConnection().close();
        }
    }

    public static void rollback() throws SQLException {
        getConnection().rollback();
    }
}
