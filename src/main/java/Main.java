import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection con;
        Statement stmt = null;
        ResultSet rs = null;


        con = ConnectionMYDB.getConnection();
        stmt=con.createStatement();


        //massa prints
        System.out.println("Welcome to LTU Library");
        System.out.println();

        System.out.println("Please login");
        System.out.println("Username");
        Scanner input1 = new Scanner(System.in);
        String usernameInput = input1.nextLine();
        String findUser = "{ CALL spFindUser(?)}";
        String userFromDB = null;

        try {
        CallableStatement callableStatement = con.prepareCall(findUser);
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
         catch(SQLException sqlException){
            sqlException.printStackTrace();
          sqlException.getCause();
        } //end catch
    }
}

