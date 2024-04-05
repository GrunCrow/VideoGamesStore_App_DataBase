package model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class ConnectionDB {

    private Connection connection = null;

    public ConnectionDB() throws ClassNotFoundException, SQLException {
        String url = "jdbc:oracle:thin:@172.17.20.75:1521:rabida";
        String username = "ISDD_003";
        String password = "alberto";
        connection = DriverManager.getConnection(url, username, password);
    }

    public ConnectionDB(String server, String IP, String db, String user, String password) throws SQLException {

        String url = "jdbc:" + server + ":thin:@" + IP + ":1521:" + db;

        connection = DriverManager.getConnection(url, user, password);

    }

    public ConnectionDB(String url, String user, String password) throws SQLException {

        connection = DriverManager.getConnection(url, user, password);

    }

    public boolean disconnect() throws SQLException {
        if (connection != null) {
            connection.close();
            return true;
        } else {
            return false;
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
