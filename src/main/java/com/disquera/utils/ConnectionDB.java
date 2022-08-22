package com.disquera.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    // Instantiate the variables to connect database
    private final String driver;
    private final String user;
    private final String password;
    private final String dataBase;
    private final String urlDB;



    // Instantiate object connection
    private Connection connection;

    public ConnectionDB(){
        driver = "com.mysql.cj.jdbc.Driver";
        user = "root";
        password = "";
        dataBase = "disqueradb";
        urlDB = "jdbc:mysql://localhost:3306/" + dataBase;

        // Connect to database
        try {
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(urlDB, user,password);
            System.out.println("Conexion ok!");

        } catch (Exception e) {
            System.out.println("Error al conectarse" + e);

        }
    }

    public Connection cerrarConexion() throws SQLException {
        connection.close();
        connection = null;
        return connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main (String [] args){
        new ConnectionDB();
    }

}
