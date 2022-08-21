package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    //establecer variables para la conexion
    private final String base = "disqueradb";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/"+base;

    Connection con;
    //crear metodo para realizar la conexion
    public Conexion()
    {
        try {
            //ruta del driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtener la conexion con la base de datos
            con= DriverManager.getConnection(this.url,this.user,this.password);
            System.out.println("Conexion oc:)");
        } catch (Exception e) {
            //imprimir error si no se conecta correctamente
            System.err.println("Error"+e);
        }
    }
    //metodo para retornar la conexion
    public  Connection getConnetion(){
        return con;
    }
    public static void main (String [] args){
        new Conexion();
    }

}
