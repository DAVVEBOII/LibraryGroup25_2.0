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

        //massa prints//
        System.out.println("Welcome to LTU Library");
        System.out.println();

        System.out.println("");
        System.out.println("");
        Scanner input1 = new Scanner(System.in);
        String usernameInput = input1.nextLine();

        try {
            callableStatement = conn.prepareCall(findUser);
            callableStatement.setString(1, usernameInput);
            rs = callableStatement.executeQuery();

            while (rs.next()) {
                userFromDB = rs.getString("username");
            }
            if (usernameInput.equals(userFromDB)) {
                System.out.println("User found");
            } else {
                System.out.println("User not found");
            } //end while
        } //end try
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        } //end catch
        finally //ensure resultSet, statement and connection are closed
        {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } //end try
            catch ( SQLException sqlException){
            sqlException.printStackTrace();
        }//end catch
        }//end finally
    }//end main
}//end class
