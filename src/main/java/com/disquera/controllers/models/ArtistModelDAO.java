package com.disquera.controllers.models;

import com.disquera.controllers.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArtistModelDAO extends ConnectionDB {

    // Instantiate variables
    Connection connection;
    String sql;
    PreparedStatement query;
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
    public ArrayList<MusicVO> consultMusic(){
        ArrayList<MusicVO> musicList = new ArrayList<>();
        try {
            // connect to dabase
            connection = this.getConnection();
            sql = "SELECT cancion.idCancion, cancion.nombreCancion, cancion.fechaGrabacion, cancion.duracionCancion, cancion.idAlbumFK, cancion.estadoCancion FROM cancion INNER JOIN album a on cancion.idAlbumFK = a.idAlbum INNER JOIN artista a2 on a.idArtistaFK = a2.idArtista INNER JOIN usuario u on a2.idUsuarioFK = u.idUsuario WHERE idUsuario = ?;";
            query = connection.prepareStatement(sql);
            query.setString(1, userId);
            ResultSet resultSet = query.executeQuery();
            while (resultSet.next()){
                MusicVO musicVO = new MusicVO(resultSet.getString("idCancion"), resultSet.getString("nombreCancion"), resultSet.getString("fechaGrabacion"), resultSet.getString("duracionCancion"), resultSet.getString("idAlbumFK"), resultSet.getString("estadoCancion"));
                musicList.add(musicVO);
            }

            return musicList;
        }catch (SQLException e){
            Logger.getLogger(MusicVO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
