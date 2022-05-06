import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        con = Connection.getConnection();
        stmt = Connection.createStatement();

        //massa prints
        System.out.println("Welcome to LTU Library");
        System.out.println();

        System.out.println("Please login");
        System.out.println("Username");
        Scanner input1 = new Scanner(System.in);
        String usernameInput = input1.nextLine();
    }
}

