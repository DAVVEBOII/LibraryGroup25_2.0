import java.sql.*;

public class Connection {
  private static String url = "jdbc:mysql://localhost:3306/library?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
  private static String driverName = "com.mysql.jdbc.Driver";
  private static String username = "libraryuser";
  private static String password = "abcd1234";
  private static Connection con;
  private static Statement stmt;
  private static String urlstring;

  public static Connection getConnection() {
      try {
          Class.forName(driverName);
          try {
              con = (Connection) DriverManager.getConnection(urlstring, username, password);
          } catch (SQLException ex) {
              System.out.println("Failed to create fag");
          }
      } catch (ClassNotFoundException ex) {
          System.out.println("Fuck you");
      }
      return con;
  }
  public static Statement createStatement() {
      return null;
  }



}
