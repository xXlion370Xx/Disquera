package Models;

import Utils.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO extends ConexionDB {

    //Se declaran las variables y los objetos
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private Boolean operacion = false;
    private String sql;
    private String idUsuario = "", nombreUsuario = "", passwordUsuario = "", rolUsuario = "", estadoUsuari = "";

    //2. Metodo constructor para recdibir datos del VO
    public UsuarioDAO(UsuarioVO usuVO) {

        super();
        //3. Conectarse
        try {
            conexion = this.obtenerConexion();
            //4. Traer al DAO los datos del VO para hacer la operación
            idUsuario = usuVO.getIdUsuario();
            nombreUsuario = usuVO.getNombreUsuario();
            passwordUsuario = usuVO.getPasswordUsuario();
            rolUsuario = usuVO.getRolUsuario();
            estadoUsuari = usuVO.getEstadoUsuario();

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public UsuarioVO consultarNombre(String nombre) {

        UsuarioVO UsuVO = null;
        try {
            sql = "select * from usuario WHERE nombreUsuario = ?";
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombre);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                UsuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(4));
            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

            }

        }
        return UsuVO;
    }

    public ArrayList<UsuarioVO> listar() {

        ArrayList<UsuarioVO> listaUsuario = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select* from usuario";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                UsuarioVO usuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5));

                listaUsuario.add(usuVO);
            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        }
        return listaUsuario;
    }

    public boolean iniciarSesion(String usuario, String clave) {

        try {

            conexion = this.obtenerConexion();
            sql = "select * from usuario where NombreUsuario = ? and PasswordUsuario = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuario);
            puente.setString(2, clave);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                operacion = true;
            }

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

            }
            return operacion;
        }
    }

    public UsuarioVO consultarUsuario(String nombreUsuario, String PasswordUsuario) {

        UsuarioVO usuVO = null;

        try {

            conexion = this.obtenerConexion();
            sql = "select * from usuario where nombreUsuario = ? and PasswordUsuario = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombreUsuario);
            puente.setString(2, PasswordUsuario);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                usuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5));
            }

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

            }
            return usuVO;
        }
    }

    @Override
    public boolean agregarRegistro() {
        return false;
    }

    @Override
    public boolean actualizarRegistro() {
        return false;
    }

    @Override
    public boolean eliminarRegistro() {
        return false;
    }
}

