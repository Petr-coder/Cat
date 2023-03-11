package part5.DB_connection;

import java.sql.Connection;

public interface DatabaseConnectionFactory {
    Connection getConnection();
}

