package by.milosh.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnectionHelper {

    private Connection connection;

    public DataBaseConnectionHelper() throws SQLException {
        connection = DataBaseConnector.getConnection();
    }

    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    public ResultSet getResultSet(String query) throws SQLException {
        return createStatement().executeQuery(query);
    }
}
