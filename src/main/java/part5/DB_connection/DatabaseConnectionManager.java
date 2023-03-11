package part5.DB_connection;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    private DatabaseConnectionFactory connectionFactory;

    public DatabaseConnectionManager(DatabaseConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void setConnectionFactory(DatabaseConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public Connection getConnection() {
        return connectionFactory.getConnection();
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
