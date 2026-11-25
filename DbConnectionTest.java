
import forex.dao.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnectionTest {
    public static void main(String[] args) {
        System.out.println("Connecting to TiDB Cloud...");

        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                 "SELECT DATABASE(), CURRENT_USER(), " +
                 "(SELECT COUNT(*) FROM information_schema.tables " +
                 "WHERE table_schema = DATABASE())")) {

            if (rs.next()) {
                System.out.println("\n================================");
                System.out.println("TIDB CONNECTION SUCCESSFUL!");
                System.out.println("Database: " + rs.getString(1));
                System.out.println("User: " + rs.getString(2));
                System.out.println("Tables found: " + rs.getInt(3));
                System.out.println("================================");
            }

        } catch (Exception e) {
            System.out.println("\nCONNECTION FAILED!");
            e.printStackTrace();
        }
    }
}
