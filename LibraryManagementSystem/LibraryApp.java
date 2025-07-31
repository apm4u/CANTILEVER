import java.sql.*;
import java.util.Scanner;

public class LibraryApp {
    static final String DB_URL = "jdbc:mysql://localhost:3306/library";
    static final String USER = "root";
    static final String PASS = "password"; // Change this to your MySQL password

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Statement stmt = conn.createStatement();
            while (true) {
                System.out.println("1. Add Book\n2. View Books\n3. Issue Book\n4. Return Book\n5. Exit");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter book title: ");
                        String title = sc.next();
                        System.out.print("Enter author: ");
                        String author = sc.next();
                        stmt.executeUpdate("INSERT INTO books(title, author, issued) VALUES('" + title + "', '" + author + "', false)");
                        System.out.println("Book added.");
                        break;
                    case 2:
                        ResultSet rs = stmt.executeQuery("SELECT * FROM books");
                        while (rs.next()) {
                            System.out.println(rs.getInt("id") + " - " + rs.getString("title") + " by " + rs.getString("author") + " | Issued: " + rs.getBoolean("issued"));
                        }
                        break;
                    case 3:
                        System.out.print("Enter book id to issue: ");
                        int id = sc.nextInt();
                        stmt.executeUpdate("UPDATE books SET issued = true WHERE id=" + id);
                        System.out.println("Book issued.");
                        break;
                    case 4:
                        System.out.print("Enter book id to return: ");
                        id = sc.nextInt();
                        stmt.executeUpdate("UPDATE books SET issued = false WHERE id=" + id);
                        System.out.println("Book returned.");
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
