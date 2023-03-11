package part5;

import part5.DB_connection.DatabaseConnectionManager;
import part5.DB_connection.MySQLConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            // Get a connection factory
            DatabaseConnectionManager connectionManager = new DatabaseConnectionManager(
                    new MySQLConnectionFactory("jdbc:mysql://localhost:3306/world","root","1234"));

            // Get a connection to the world database
            Connection connection = connectionManager.getConnection();
            // Execute the queries
            String query1 = "SELECT City.Name, Country.Name FROM City " +
                    "JOIN Country ON City.CountryCode = Country.Code " +
                    "WHERE City.Population > 1000000 " +
                    "ORDER BY City.Population DESC";

            String query2 = "SELECT COUNT(*) FROM City " +
                    "JOIN Country ON City.CountryCode = Country.Code " +
                    "WHERE Country.Name = 'United States' " +
                    "AND Country.Code NOT IN ('TX', 'UT')";

            String query3 = "SELECT CountryCode, COUNT(*) FROM City " +
                    "WHERE Name LIKE '%en' " +
                    "GROUP BY CountryCode";

            Map<String, String> results1 = executeQuery(connection, query1, "City.Name", "Country.Name");
            int results2 = executeCountQuery(connection, query2);
            Map<String, Integer> results3 = executeGroupByQuery(connection, query3, "CountryCode", "COUNT(*)");

            // Print the results
            System.out.println("Cities and Countries with more than 1 million residents:");
            results1.keySet().stream().map(key -> key + " - " + results1.get(key)).forEach(System.out::println);

            System.out.println("\nNumber of cities in the United States, excluding Texas and Utah counties: " + results2);

            System.out.println("\nNumber of cities ending in 'en' by country code:");
            results3.keySet().stream().map(key -> key + " - " + results3.get(key)).forEach(System.out::println);

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> executeQuery(Connection connection, String query, String columnName1, String columnName2) throws SQLException {
        Map<String, String> results = new HashMap<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String column1 = resultSet.getString(columnName1);
            String column2 = resultSet.getString(columnName2);
            results.put(column1, column2);
        }

        return results;
    }

    public static int executeCountQuery(Connection connection, String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        resultSet.next();
        return resultSet.getInt(1);
    }

    public static Map<String, Integer> executeGroupByQuery(Connection connection, String query, String columnName1, String columnName2) throws SQLException {
        Map<String, Integer> results = new HashMap<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String column1 = resultSet.getString(columnName1);
            int column2 = resultSet.getInt(columnName2);
            results.put(column1, column2);
        }

        return results;
    }
}
