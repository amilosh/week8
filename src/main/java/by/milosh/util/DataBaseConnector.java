package by.milosh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataBaseConnector {

    private static final String URL;
    private static final String LOGIN;
    private static final String PASSWORD;


    static {
        ResourceBundle resource = ResourceBundle.getBundle(DataBaseParameter.DATABASE.getParameter());
        URL = resource.getString(DataBaseParameter.URL.getParameter());
        LOGIN = resource.getString(DataBaseParameter.LOGIN.getParameter());
        PASSWORD = resource.getString(DataBaseParameter.PASSWORD.getParameter());
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, LOGIN, PASSWORD);
    }
}
