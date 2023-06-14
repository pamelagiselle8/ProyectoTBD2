
package proyecto02tbd02;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Test {
    Connection conn = null;
    String nomBD = "";
    String url = "jdbc:postgresql://localhost:5432/" + nomBD;
    String user = "postgres";
    String pass = "patitos";
    
    public Connection conectarPostgreSQL() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar\n" + e);
        }
        return conn;
    }
}
