package Modelo;
import Conexion.Conexion;
import Control.Usuario;

import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Agenda {
    private Vector <Usuario> vector = new Vector<>();
    Usuario usuario = new Usuario();
    public void GuardarUsuario(Usuario usuario){
        vector.add(usuario);
        try (Connection con = Conexion.getConnection()){
            String sql="INSERT INTO usuarios(nombre,apellido,dni,email,domicilio,usuario)values(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.nombre);
            ps.setString(2, usuario.apellido);
            ps.setString(3, usuario.dni);
            ps.setString(4, usuario.email);
            ps.setString(5, usuario.domicilio);
            ps.setString(6, usuario.usuario);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Se agrego correctamente");

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al guardar en database:\n"+ e.getMessage());
            e.printStackTrace();
        }
    }
    
    public Vector<Usuario> Mostrar() {
    Vector<Usuario> lista = new Vector<>();    
    try (Connection con = Conexion.getConnection()) {
        String sql = "SELECT id_usuario, nombre, apellido,dni,email, domicilio, usuario FROM usuarios";
        PreparedStatement ps = con.prepareStatement(sql);
        java.sql.ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Usuario u = new Usuario(
                rs.getInt("id_usuario"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("dni"),
                rs.getString("email"),
                rs.getString("domicilio"),
                rs.getString("usuario")
            );
            lista.add(u);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cargar desde la base de datos: " + e.getMessage());
    }
    return lista;
}
    public boolean editar(Usuario u){
        boolean update = false;
        try (Connection con = Conexion.getConnection()){
            String sql = "UPDATE usuarios set nombre=?,apellido=?,dni=?,email=?,domicilio=?,usuario=? "
                    + "WHERE id_usuario=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.nombre);
            ps.setString(2, u.apellido);
            ps.setString(3, u.dni);
            ps.setString(4, u.email);
            ps.setString(5, u.domicilio);
            ps.setString(6, u.usuario);
            ps.setInt(7, u.codigo);
            if(ps.executeUpdate()>0){
                update=true;
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al actualizar usuario: " + e.getMessage());
        }
        return update;
    }
    public Vector<Usuario> getVector(){
        return vector;
    }    
    public boolean borrar (Usuario u){
        boolean delete = false;
        try(Connection con = Conexion.getConnection()){
            String sql=("DELETE FROM usuarios WHERE id_usuario=?");
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, u.codigo);
            
            if (ps.executeUpdate() > 0) {
                delete = true;
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al borrar usuario: " + e.getMessage());
        }
        return delete;
    }
}
