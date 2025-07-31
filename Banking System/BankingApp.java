import java.sql.*;
import java.util.Scanner;

public class BankingApp {
    static final String DB_URL = "jdbc:mysql://localhost:3306/bank";
    static final String USER = "root";
    static final String PASS = "password"; // Change this to your MySQL password

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Statement stmt = conn.createStatement();
            while (true) {
                System.out.println("1. Create Account\n2. View Balance\n3. Deposit\n4. Withdraw\n5. Exit");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.next();
                        System.out.print("Enter initial deposit: ");
                        double amount = sc.nextDouble();
                        stmt.executeUpdate("INSERT INTO accounts(name, balance) VALUES('" + name + "', " + amount + ")");
                        System.out.println("Account created.");
                        break;
                    case 2:
                        System.out.print("Enter account id: ");
                        int id = sc.nextInt();
                        ResultSet rs = stmt.executeQuery("SELECT balance FROM accounts WHERE id=" + id);
                        if (rs.next()) System.out.println("Balance: " + rs.getDouble("balance"));
                        else System.out.println("Account not found.");
                        break;
                    case 3:
                        System.out.print("Enter account id: ");
                        id = sc.nextInt();
                        System.out.print("Enter amount to deposit: ");
                        amount = sc.nextDouble();
                        stmt.executeUpdate("UPDATE accounts SET balance = balance + " + amount + " WHERE id=" + id);
                        System.out.println("Deposit successful.");
                        break;
                    case 4:
                        System.out.print("Enter account id: ");
                        id = sc.nextInt();
                        System.out.print("Enter amount to withdraw: ");
                        amount = sc.nextDouble();
                        stmt.executeUpdate("UPDATE accounts SET balance = balance - " + amount + " WHERE id=" + id);
                        System.out.println("Withdrawal successful.");
                        break;
                    case 5:
                        System.out.println("Goodbye!");
                        System.exit(0);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
