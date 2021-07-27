package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Connect to the database (MySQL) Database: facial_recognition
 *
 */
public class ConnectDB {

    public Statement stm;
    public ResultSet rs;
    public Connection conn;

    private final String path = "jdbc:mysql://localhost:3306/facial_recognition";
    private final String user = "root";
    private final String pass = "root";

    /**
     * Method responsible for opening the connection to the database.
     * 
     * Yes. This method must be invoked whenever you perform an operation that
     * involves the database.
     * 
     * @exception Error Database not exists, driver not configured correctly,
     * library was not added to the project
     */
    public void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //string is the MySQL server to connect to
            conn = DriverManager.getConnection(path, user, pass);
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method responsible for closing the connection to the database.
     * No. but it is advisable to close the connection every time you perform a
     * database operation.
     *
     * @exception Error Connection not started.
     */
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * Method is used to execute SELECT query. It returns the object of
     * ResultSet.
     *
     * @param SQL ex: "SELECT * FROM table"
     * @exception Error Connection not started.
     */
    public void executeSQL(String SQL) {
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(SQL);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
