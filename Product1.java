import java.sql.*;

public class Product1 {
    private int id;
    private String name;
    private double price;

    // Constructor
    public Product1(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

public class ProductDatabase {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myUsername";
    private static final String PASS = "myPassword";

    public Product1 getProductDetails(int productId) {
        Product1 product = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Establish connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Prepare statement
            String sql = "SELECT id, name, price FROM products WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, productId);

            // Execute query
            rs = stmt.executeQuery();

            // Process result
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                product = new Product1(id, name, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        } finally {
            // Close resources in a finally block
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return product;
    }

    // Other database operations for CRUD (Create, Read, Update, Delete) can be added here
}