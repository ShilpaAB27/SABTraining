import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/myDatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "yourPassword";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            connection.setAutoCommit(false);

            createTable(connection);
            insertProduct(connection, 1, "Product1", 100);
            insertProduct(connection, 2, "Product2", 200);
            updateProduct(connection, 1, "UpdatedProduct1", 150);
            deleteProduct(connection, 2);

            connection.commit();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE Products (" +
                "id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(255)," +
                "price DECIMAL(10, 2))";
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
    }

    private static void insertProduct(Connection connection, int id, String name, double price) throws SQLException {
        String sql = "INSERT INTO Products (id, name, price) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setString(2, name);
        statement.setDouble(3, price);
        statement.execute();
        statement.close();
    }

    private static void updateProduct(Connection connection, int id, String name, double price) throws SQLException {
        String sql = "UPDATE Products SET name = ?, price = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setDouble(2, price);
        statement.setInt(3, id);
        statement.execute();
        statement.close();
    }

    private static void deleteProduct(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM Products WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.execute();
        statement.close();
    }
}