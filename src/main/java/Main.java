import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection con;
        Statement stmt = null;
        ResultSet rs = null;
        CallableStatement callableStatement = null;
        con = ConnectionMYDB.getConnection();
        stmt = con.createStatement();

        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        String usernameInput = input1.nextLine();
        String passwordInput = input2.nextLine();
        String findUser = "{ CALL spFindUser(?) }";
        String checkPassword = ("{ CALL spCheckPassword(?, ?) }");
        String userFromDB = null;
        String pwdFromDB = null;

        //prints vid startup
        System.out.println("Welcome to LTU Library");
        System.out.println();
        System.out.println("Please login");
        System.out.println("Username");

        try {
            callableStatement = con.prepareCall(findUser);
            //callableStatement = con.prepareCall(checkPassword);
            callableStatement.setString(1, usernameInput);
            //callableStatement.setString(2, passwordInput);
            rs = callableStatement.executeQuery();

            while (rs.next()) {
                userFromDB = rs.getString("username");

                if (usernameInput.equals(userFromDB)) {
                    System.out.println("User found");
                } else {
                    System.out.println("User not found");
                    break;
                } //end while
            }

            try {
                callableStatement = con.prepareCall(checkPassword);
                callableStatement.setString(1, usernameInput);
                callableStatement.setString(2, passwordInput);
                rs = callableStatement.executeQuery();

                while (rs.next()) {
                    pwdFromDB = rs.getString("pwd");
                    if (passwordInput.equals(pwdFromDB)) {
                        System.out.println("Password finns");
                    } else {
                        System.out.println("NEJ");
                        break;
                    }
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                ex.getCause();
            } //end catch

        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getCause();
        } //end catch
    }
}

