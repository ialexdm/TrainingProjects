package dataBase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.services.AuthenticationServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ResourceBundle;

public class DBConn {//Singleton

    private static DBConn instance;
    private Connection conn;

    private DBConn() throws SQLException {

        ResourceBundle rb = ResourceBundle.getBundle("db");
        String host = rb.getString("host");
        String port = rb.getString("port");
        String db = rb.getString("db");
        String user = rb.getString("user");
        String password = rb.getString("password");

        String jdbcURL = MessageFormat.format("jdbc:mysql://{0}:{1}/{2}?useUnicode=true&serverTimezone=UTC", host, port, db);
        conn = DriverManager.getConnection(jdbcURL, user, password);
    }

    public static DBConn getInstance(){
        final Logger LOGGER = LogManager.getLogger(AuthenticationServiceImpl.class);
        if (instance == null){
            try {
                instance = new DBConn();
            } catch (SQLException throwables) {
                LOGGER.error(throwables.getStackTrace());
            }
        }
        return instance;
    }
    public Connection connection(){
        return conn;
    }
}
