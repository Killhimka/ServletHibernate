package org.example.MySQLHw;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectorDB {
    public static Connection getConnectorDB (){
        Connection dbConnection = null;
        String userName = "root";
        String password = "Himk@175554175";
        String connectionUrl = "jdbc:mysql://localhost:3306/pets";
        try { Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
        }
        try {
            dbConnection = DriverManager.getConnection(connectionUrl,userName,password);
            System.out.println("Yes");
            return dbConnection;
        } catch (Exception e){
        }
        return dbConnection;
    }
}
