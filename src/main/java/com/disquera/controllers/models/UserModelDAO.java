package com.disquera.controllers.models;

import com.disquera.controllers.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserModelDAO extends ConnectionDB {

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

    public boolean validateLogin(){
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

    // Login method return information about user
    public ArrayList<UserModelVO> listUserData() throws SQLException {
        ArrayList<UserModelVO> userData = new ArrayList<>();
        try{
            // Do prepare statement to get de result query
            sql = "SELECT * FROM usuario WHERE nombreUsuario = ? AND passwordUsuario = ?";
            query = connection.prepareStatement(sql);
            query.setString(1, user);
            query.setString(2, password);
            // Execute query
            ResultSet resultSet = query.executeQuery();

            while (resultSet.next()) {

                UserModelVO userModelVO = new UserModelVO(resultSet.getString(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));

                userData.add(userModelVO);
            }
            this.cerrarConexion();
            return userData;

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
