import java.sql.*;
import java.util.Scanner;

public class Main {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/library?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;

        String findUser = "{ CALL spFindUser(?)}";
        String userFromDB = null;
        String findPasswordMatch = "{ CALL spFindUserPassword(?,?)}";
        String pwdFromDB = null;

        try {
            //establish connection with DB
            conn = DriverManager.getConnection(DATABASE_URL, "libraryuser", "abcd1234");
        } catch (SQLException sqlException) {
            System.out.println("David sämst");
        }

        Scanner input1 = new Scanner(System.in);
        String usernameInput = input1.nextLine();
        rs = callableStatement.executeQuery();

        try {
            callableStatement = conn.prepareCall(findUser);
            callableStatement.setString(1, usernameInput);

            while (resultSet.next())
        }
    }
}