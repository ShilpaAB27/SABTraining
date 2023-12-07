package in.sp.test;

import java.sql.DriverManager;

public class insert 
{
   public static void main(String[]args) throws Exception
   {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getconnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "root");
      
      con.preparsetatement("insert into table_name");
   }
}
