package shilpaalok;
import java.sql.*;

public class InsertDemo {

    static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "your_username";
    static final String PASS = "your_password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            conn.setAutoCommit(true); // Enable auto-commit mode

            // Inserting data into a sample table
            try (Statement stmt = conn.createStatement()) {
                String sql = "INSERT INTO your_table (column1, column2) VALUES ('value1', 'value2')";
                stmt.executeUpdate(sql);
                System.out.println("Data inserted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
                conn.rollback(); // Rollback the transaction if an error occurs
            }

            // Update data in the same table
            try (Statement stmt = conn.createStatement()) {
                String sql = "UPDATE your_table SET column1 = 'new_value' WHERE column2 = 'value2'";
                stmt.executeUpdate(sql);
                System.out.println("Data updated successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
                conn.rollback(); // Rollback the transaction if an error occurs
            }

            // Delete data from the table
            try (Statement stmt = conn.createStatement()) {
                String sql = "DELETE FROM your_table WHERE column1 = 'new_value'";
                stmt.executeUpdate(sql);
                System.out.println("Data deleted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
                conn.rollback(); // Rollback the transaction if an error occurs
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}