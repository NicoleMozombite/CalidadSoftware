package Modelo;
import Vistas.PrincipalMultiservicios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;

public class Conexion {
    static Connection con = null;
        public static final String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        public static final String user="sa";
        public static final String pas="root";
        public static final String url = "jdbc:sqlserver://DESKTOP-Q9H7KO3\\EQUIPOHP:1433;databaseName=MultiserviciosSA";

    public Conexion(){
        con=null;
        try{
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url,user,pas);
            if(con!= null){
            System.err.println("conexion Exitosa");
        }
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("No se Conecto a la base de Datos");
        }
    }
    public Connection getConeccion(){
        return con;
    }
    
    public void desconectar(){
        con=null;
        if(con == null){
            System.out.println("terminado");
        }
    }
    public static boolean setCuenta(String usuario, String password ){
        if(usuario.equals(user) && password.equals(pas)){
            return true;
        }else{
            return false;
        }
    }
/*    public static ResultSet Consulta(String consulta){
        Connection con = getCo();
        Statement declara;
        try{
            declara=con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        }catch(SQLException e){
            System.out.println("No se Conecto a la base de Datos");
        }return null;
    }
*/
}
