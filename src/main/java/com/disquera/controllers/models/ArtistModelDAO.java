package com.disquera.controllers.models;

import com.disquera.controllers.utils.ConnectionDB;

import java.sql.Connection;

public class ArtistModelDAO extends ConnectionDB {

    // Instantiate variables
    Connection connection;
    private String id;
    private String numDoc;
    private String typeDoc;
    private String name;
    private String lastName;
    private String nickname;
    private String birthDay;
    private String email;
    private String company;
    private String status;
    private String userId;

    public ArtistModelDAO(ArtistModelVO artistModelVO){
        connection = this.getConnection();
        id = artistModelVO.getId();
        numDoc = artistModelVO.getNumDoc();
        typeDoc = artistModelVO.getTypeDoc();
        name = artistModelVO.getName();
        lastName = artistModelVO.getLastName();
        nickname = artistModelVO.getNickname();
        birthDay = artistModelVO.getBirthDay();
        email = artistModelVO.getEmail();
        company = artistModelVO.getCompany();
        status = artistModelVO.getStatus();
        userId = artistModelVO.getUserId();
    }

    // Create method consult songs
}
