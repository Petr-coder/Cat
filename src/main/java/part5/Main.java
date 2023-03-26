package part5;

import part5.DB_connection.DatabaseConnectionManager;
import part5.DB_connection.MySQLConnectionFactory;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            // Get a connection factory
            DatabaseConnectionManager connectionManager = new DatabaseConnectionManager(
                    new MySQLConnectionFactory("jdbc:mysql://localhost:3306/world", "root", "1234"));

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

            String sqlQuery4 = "SELECT c.Name, cl.Language FROM city c JOIN countrylanguage cl ON c.CountryCode = cl.CountryCode WHERE c.Population < 10000 AND cl.IsOfficial = true";

            try (PreparedStatement stmt = connection.prepareStatement(sqlQuery4)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getString("Name") + ", " + rs.getString("Language"));
                }
            }

            String sqlQuery5 = "SELECT c.Name FROM city c " +
                    "JOIN country co ON c.CountryCode = co.Code " +
                    "JOIN countrylanguage cl ON co.Code = cl.CountryCode " +
                    "GROUP BY c.Name " +
                    "HAVING COUNT(DISTINCT cl.Language) >= 4";

            String sqlQuery6 = "SELECT COUNT(distinct Name) FROM city WHERE CountryCode IN (SELECT CountryCode " +
                    "FROM countrylanguage WHERE IsOfficial = 'T' and Percentage<1)";

            String sqlQuery7 = "SELECT COUNT(*) FROM city " +
                    "WHERE Language NOT IN (SELECT Language FROM countrylanguage WHERE IsOfficial = 'T') " +
                    "AND Population > 0.01*(SELECT SUM(Population) FROM city)";

            String sqlQuery8 = "SELECT c.Name AS country_name, ci.Name AS district_name\n" +
                    "FROM country c\n" +
                    "JOIN city ci ON c.Code = ci.CountryCode\n" +
                    "WHERE c.Continent = 'Africa'\n" +
                    "AND c.Region = 'Western Africa'\n" +
                    "AND c.LifeExpectancy > 60\n" +
                    "AND (SELECT SUM(Percentage) FROM countrylanguage WHERE CountryCode = c.Code AND IsOfficial = 'F') > 10";

            String query9 = "SELECT c.Name AS country_name, c.GovernmentForm, cl.Language\n" +
                    "FROM country c\n" +
                    "JOIN countrylanguage cl ON c.Code = cl.CountryCode\n" +
                    "WHERE c.GovernmentForm LIKE '%epubli%'\n" +
                    "AND cl.Language = 'Spanish'\n" +
                    "AND c.Region LIKE '%America';";

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
