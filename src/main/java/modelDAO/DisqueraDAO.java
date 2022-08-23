package modelDAO;

import Utils.Conexion;
import modelVO.DisqueraVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisqueraDAO extends Conexion {
    //declarar variables y objetos
    private Connection con;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    private String idDisquera = "", nitDisquera = "", nombreDisquera = "", telefonoDisquera = "", direccionDisquera = "", estadoDisquera = "";

    //metodo constructor para recibir los datos
    public DisqueraDAO() {
    }

    public DisqueraDAO(DisqueraVO disVO) {
        super();

        //conectarse
        try {
            con = this.getConnetion();
            //traer al dao los datos del vo
            idDisquera = disVO.getIdDisquera();
            nitDisquera = disVO.getNitDisquera();
            nombreDisquera = disVO.getNombreDisquera();
            telefonoDisquera = disVO.getTelefonoDisquera();
            direccionDisquera = disVO.getDireccionDisquera();
            estadoDisquera = disVO.getEstadoDisquera();

        } catch (Exception e) {
            Logger.getLogger(DisqueraVO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //metodo para agregar disquera
    public boolean agregarRegistro(){
        try {
            sql = "INSERT INTO disquera(nitDisquera,nombreDisquera,telefonoDisquera,direccionDisquera,estadoDisquera) VALUES(?,?,?,?,?)";
            puente = con.prepareStatement(sql);
            puente.setString(1, nitDisquera);
            puente.setString(2,nombreDisquera);
            puente.setString(3,telefonoDisquera);
            puente.setString(4,direccionDisquera);
            puente.setString(5,estadoDisquera);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(DisqueraVO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion();
            }catch (SQLException e) {
                Logger.getLogger(DisqueraVO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    //metodo para consultar por nit

    public DisqueraVO consultarNit (String nitDisquera){
        DisqueraVO disVO = null;
        try{
            con = this.getConnetion();
            sql = "SELECT * FROM disquera WHERE nitDisquera = ?";
            puente = con.prepareStatement(sql);
            puente.setString(1,nitDisquera);
            mensajero = puente.executeQuery();
            operacion = true;
            while (mensajero.next()){
                disVO = new DisqueraVO(mensajero.getString(2), mensajero.getString(3),
                        mensajero.getString(4), mensajero.getString(5),mensajero.getString(6));
                }
            }catch (SQLException e){
            Logger.getLogger(DisqueraVO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(DisqueraVO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return disVO;
    }


    //metodo para listar las disqueras

    public ArrayList<DisqueraVO>listar(){
        ArrayList<DisqueraVO>listaDisquera = new ArrayList<>();
        try {
            con = this.getConnetion();
            sql = "SELECT * FROM disquera";
            puente = con.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()){
                DisqueraVO disVO = new DisqueraVO(mensajero.getString(1),mensajero.getString(2),mensajero.getString(3),
                        mensajero.getString(4),mensajero.getString(5));
                        listaDisquera.add(disVO);
            }
        }catch (Exception e) {
            Logger.getLogger(DisqueraVO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaDisquera;
    }
}
