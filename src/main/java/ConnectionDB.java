import java.sql.*;

public class ConnectionDB {
    static final String url = "jdbc:mysql://localhost:3306/library?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

    private static String username = "libraryuser";
    private static String password = "abcd1234";
    private static Connection con;
    private static Statement stmt;
    private static String urlstring;

    public static Connection getConnection() {

          try {
              con = DriverManager.getConnection(url, username, password);
          } catch (SQLException ex) {
              System.out.println("Failed to say fuck you");
          }
      return con;
  }//ConnectionDB connection = new ConnectionDB();
  //Connection con = ConnectionDB.getConnection();
}
