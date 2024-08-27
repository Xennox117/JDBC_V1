package laConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
// la conexion
public class update {
    public static void main(String[] args) {
        
   
    String usuario="root";
    String url="jdbc:mysql://localhost:3306/test";
    String password="36279684";   
    String driver="com.mysql.cj.jdbc.Driver";
    Connection conexion;
    Statement statement;
    ResultSet rs;

        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                 System.out.println(rs.getString("id") + " nombre= " + (rs.getString("nombre") + " correo= " + (rs.getString("correo") + " direccion=" + (rs.getString("direccion")))));  
            
            }   
            // actualizar datos 
            statement.execute("UPDATE `usuarios` SET `nombre` = 'juan', `correo` = 'lora@gmail.com', `direccion` = 'no copeo de nada hijo' WHERE `usuarios`.`id` = 10;");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                             
            }           
           
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
