 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class TestOracleJDBC {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
           // con = DriverManager.getConnection("jdbc:oracle:thin:SIDTHETOWNBOY/$ID@123@localhost");
        
            
           
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sidharth","$ID@123");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM FSL");
            while(rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.println(rs.getString(2));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}