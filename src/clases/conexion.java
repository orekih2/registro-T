
package clases;
import java.sql.*;

public class conexion {
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    
    public conexion (){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/toderos","root","314aha__");
            System.out.println("conectado a la BD");
        } catch (Exception e) {
            System.err.println("Erros al conectar BD");
        } finally {
        }
    }
    
    public int reusuario(String nombre, String apellido, String cedula, String correo, String telefono, String ciudad, String departamento) {
    int res = 0;
    try {
        ps = cn.prepareStatement("INSERT INTO registro (nombre, apellido, cedula, correo, telefono, ciudad, departamento) VALUES (?,?,?,?,?,?,?)");
        ps.setString(1, nombre);
        ps.setString(2, apellido);
        ps.setString(3, cedula);
        ps.setString(4, correo);
        ps.setString(5, telefono);
        ps.setString(6, ciudad);
        ps.setString(7, departamento);
        res = ps.executeUpdate();
        System.out.println("USUARIO REGISTRADO");
    } catch (Exception e) {
        System.out.println("ERROR DE USUARIO: " + e.getMessage());
    }
    return res;
}
    public int modificar(String nombre, String apellido, String cedula, String correo, String telefono, String ciudad, String departamento, String ID) {
    int res = 0;
    try {
        ps = cn.prepareStatement("UPDATE registro SET nombre=?, apellido=?, cedula=?, correo=?, telefono=?, ciudad=?, departamento=? WHERE ID=?");
        ps.setString(1, nombre);
        ps.setString(2, apellido);
        ps.setString(3, cedula); 
        ps.setString(4, correo); 
        ps.setString(5, telefono);
        ps.setString(6, ciudad);
        ps.setString(7, departamento);
        ps.setString(8, ID);
        res = ps.executeUpdate();
        System.out.println("DATOS MODIFICADOS");
    } catch (Exception e) {
        System.out.println("ERROR AL MODIFICAR");
    } finally {
        // Es una buena práctica cerrar recursos aquí, como ps y cn
    }
    return res;
}

    
    
    public int eliminar(String ID ){
        int res=0;
        try {
            ps=cn.prepareStatement("delete from registro where ID=? ");
            ps.setString(1, ID);
            res=ps.executeUpdate();
            System.out.println("USUARIO ELIMINADO");
        } catch (Exception e) {
          System.out.println("ERROR AL ELIMMINAR");  
        } finally {
        }
        return res;
    }
    
    
    
    

    }

