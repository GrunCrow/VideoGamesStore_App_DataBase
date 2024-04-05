package Model;

import java.sql.*;


public class Connect {
    private Connection connection = null;
    
    public Connect() throws SQLException{
     final String url = "jdbc:mysql://localhost/OnlineVideogameStore";
     final String user = "root";
     final String password = "@Root2001";
     connection = DriverManager.getConnection(url, user, password);
    }
    
    public Connect(String user, String password) throws SQLException{
     final String url = "jdbc:mysql://localhost/OnlineVideogameStore";
     connection = DriverManager.getConnection(url, user, password);
    }
    
    /*public Connection(String sgbd, String ip, String bd, String usuario, String password)){
      link = DriverManager.getConnection("jdbc:oracle:thin:@localhost:OnlineVideogameStore", "root", "root");  
    };*/
    
    public void Disconnect() throws SQLException {
        connection.close();
    }
    
    public DatabaseMetaData informationDB() throws SQLException{
        return connection.getMetaData();
    }
}
