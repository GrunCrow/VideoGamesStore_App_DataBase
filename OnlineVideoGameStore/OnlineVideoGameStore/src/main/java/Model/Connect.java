package Model;

import java.sql.*;


public class Connect {
    private Connection connection = null;
    
    public Connect() throws SQLException{
        final String url = "jdbc:mysql://localhost:3306/onlinevideogamestore";
        final String user = "root";
        final String password = "@Root2001";
        connection = DriverManager.getConnection(url, user, password);
    }
    
    public Connect(String user, String password) throws SQLException{
        final String url = "jdbc:mysql://localhost:3306/onlinevideogamestore";
        connection = DriverManager.getConnection(url, user, password);
    }
    
    /*public Connection(String sgbd, String ip, String bd, String usuario, String password)){
      link = DriverManager.getConnection("jdbc:oracle:thin:@localhost:OnlineVideogameStore", "root", "root");  
    };*/
    
    public boolean Disconnect() throws SQLException {
        if (connection != null) {
            connection.close();
            return true;
        } else {
            return false;
        }
    }
    
    public DatabaseMetaData informationDB() throws SQLException{
        return connection.getMetaData();
    }
    
    public Connection getConnection() {
        return connection;
    }
}
