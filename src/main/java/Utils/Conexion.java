package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Conexion {

        private String driver,userDB,passwordDB, dataBase,urlDB;
        public Connection conexion;

        public Conexion(){

            //Paso 2, asignar valores
            driver="com.mysql.jdbc.Driver";
            userDB="root";
            passwordDB="";
            dataBase="disqueradb";
            urlDB="jdbc:mysql://localhost:3306/"+dataBase;

            // Paso 3, conectarse
            try {

                Class.forName(driver).newInstance();
                conexion= DriverManager.getConnection(urlDB, userDB, passwordDB);
                System.out.println("Conexion Bien");

            } catch (Exception e) {
                System.out.println("Error al Conectarse " + e.toString());
            }
        }

        public Connection obtenerConexion() {
            return conexion;
        }
        public Connection cerrarConexion() throws SQLException {
            conexion.close();
            conexion=null;
            return null;
        }

        public static void main(String[] args) {
            new Conexion() {
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
            };
        }

    public abstract boolean agregarRegistro();

    public abstract boolean actualizarRegistro();

    public abstract boolean eliminarRegistro();
}


