import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcExample {
  public static void main(String[] args) throws ClassNotFoundException, SQLException
  {

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager
        .getConnection("jdbc:mysql://localhost:8080unisoft", "root", "root");
System.out.println("Connection Done");

  }
}


