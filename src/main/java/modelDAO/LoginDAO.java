package modelDAO;
import Utils.Conexion;
import modelVO.LoginVO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class LoginDAO extends Conexion{

    //Declarar variables y/o objetos
    private Connection con;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private String sql;

    private boolean  operacion = false;
    private String nombreUsuario = "", passwordUsuario = "";

    //constructor para recibir los datos

    public LoginDAO(LoginVO lVO)
    {
        //conectarse a la base de datos
        try{
            con = this.getConnetion();
            //traer los datos del vo al dao
            nombreUsuario=lVO.getNombreUsuario();
            passwordUsuario=lVO.getPasswordUsuario();
        }catch(Exception e){
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null,e);
        }
    }

    public String[] validarLogin(String nombreUsuario, String passwordUsuario) {
        String[] resultado = new String[2];
        try {
            sql = "SELECT * FROM usuario WHERE nombreUsuario = ? AND passwordUsuario = ?";

            puente = con.prepareStatement(sql);
            puente.setString(1, nombreUsuario);
            puente.setString(2, passwordUsuario);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {

                String idUsuarioSQL = mensajero.getString(1);
                String idUsuario = String.valueOf(idUsuarioSQL);
                operacion = true;

                resultado[0] = idUsuario;
                resultado[1] = String.valueOf(operacion);

            }else{
                resultado[0] = null;
                resultado[1] = null;
            }

        } catch (SQLException e) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return  resultado;
    }

    public String consultarRol(String nombreUsuario, String passwordUsuario){

        String rol = null;

        try{
            sql  = "SELECT * FROM usuario WHERE nombreUsuario = ? and passwordUsuario = ?";
            puente = con.prepareStatement(sql);
            puente.setString(1, nombreUsuario);
            puente.setString(2, passwordUsuario);
            mensajero = puente.executeQuery();

            String id = null;

            if (mensajero.next()){
                id = mensajero.getString(1);
                sql = "SELECT * FROM usuario WHERE usuario.idUsuario = ?";
                puente = con.prepareStatement(sql);
                puente.setString(1, id);
                mensajero = puente.executeQuery();

                String rolUsuario = null;
                if (mensajero.next()){
                    rolUsuario= mensajero.getString(4);
                    if (rolUsuario.equals("admin")){
                        rol = "admin";
                    } else if (rolUsuario.equals("artista")) {
                        rol = "artista";

                    } else {
                        rol = null;
                    }
                }

            }
        }catch (Exception e) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return rol;
    }

}

