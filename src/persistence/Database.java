package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.*;

/**
 * This is the main database class that is consumed by all of the DAOs in this application. It contians the functionality
 * to create a new instance of the database connection and disconnect from the database.
 */
public class Database {

    private static Database instance = new Database();
    private Connection connection;
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Basic no parm constructor for the class.
     */
    private Database() {

    }

    /**
     * This method will return an instance of the database.
     * @return database - instance of database
     */
    public static Database getInstance() {
        return instance;
    }

    /**
     * This method will return an instance of the database connection.
     * @return Connection - instance of the database connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * This method will attempt to connect to the database.
     */
    public void connect() throws Exception {
        if (connection != null)
            return;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new Exception("Error: MySQL Driver not found");
        }
        String url = "jdbc:mysql://localhost:3306/sample";
        connection = DriverManager.getConnection(url, "Biwer", "Squall@123");
    }

    /**
     * This method will attempt to disconnect to the database.
     */
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("Cannot close connection",e);
            }
        }
        connection = null;
    }
}