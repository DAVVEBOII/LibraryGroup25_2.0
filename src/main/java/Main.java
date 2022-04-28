import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/library?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String findUser = "{CALL spFindTheUser(?)}";
        String userFromDB = null;
        String findPasswordMatch = "{ Call spFindPasswordMatch(?,?)}";
        String pwdFromDB = null;
        try {
            //establish connection with DB
            conn = DriverManager.getConnection(DATABASE_URL, "libraryuser", "abcd1234");
        } catch (SQLException sqlException) {
            System.out.println("David sämst");
        }
    }
}