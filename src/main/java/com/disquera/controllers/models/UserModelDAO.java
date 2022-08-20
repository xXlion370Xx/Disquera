package com.disquera.controllers.models;

import com.disquera.controllers.utils.ConectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserModelDAO extends ConectionDB {

    // Instantiate variables
    Connection connection;
    String user;
    String password;
    String sql;
    PreparedStatement query;

    public UserModelDAO(UserModelVO loginVO){

        // Connection to database
        try {
            connection = this.getConnection();
            user = loginVO.getUser();
            password = loginVO.getPassword();
        }catch (Exception e){
            Logger.getLogger(UserModelDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // Login method 
    public boolean validateLogin() throws SQLException {
        try{
            // Do prepare statement to get de result query
            sql = "SELECT * FROM usuario WHERE nombreUsuario = ? AND passwordUsuario = ?";
            query = connection.prepareStatement(sql);
            query.setString(1, user);
            query.setString(2, password);
            // Execute query
            ResultSet resultSet = query.executeQuery();
            return resultSet.next();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
