package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL ="jdbc:mysql://localhost:3306/coloquio";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection getConnection(){
        Connection con = null;
        try{
            con = DriverManager.getConnection(URL,USER,PASS);
            System.out.println("Conexion exitosa.");
        }catch (SQLException e){
            System.out.println("Error no esta levantado el xampp");
        }
        return con;
    }
}