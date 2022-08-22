package modelDAO;
import Utils.Conexion;
import modelVO.LoginVO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Integer.parseInt;

public class LoginDAO extends Conexion{

    //Declarar variables y/o objetos
    private Connection con;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private String sql;
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

    public int[] iniciarSesion(String nombreUsuario, String passwordUsuario) {
        int[] resultado = new int[2];
        try {
            sql = "SELECT * FROM usuario WHERE nombreUsuario = ? AND passwordUsuario = ?";
            puente = con.prepareStatement(sql);
            puente.setString(1, nombreUsuario);
            puente.setString(2, passwordUsuario);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {

                resultado[0] = mensajero.getInt(4);

                this.cerrarConexion();
                return resultado;

            }

            return null;

        } catch (SQLException e) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }


}

