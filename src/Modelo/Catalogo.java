package Modelo;

import Conexion.Conexion;
import Control.Producto;
import java.util.Vector;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Catalogo {
    public int categoria(String nombreCategoria){
        int id_categoria=0;
        try(Connection con = Conexion.getConnection()){
            String sql = "SELECT id_categoria FROM categoria WHERE nombre = ?";
            PreparedStatement ps = con.prepareStatement (sql);
            ps.setString(1, nombreCategoria);
            ResultSet rs = ps.executeQuery();
            rs = ps.executeQuery();
            if(rs.next()){
                id_categoria = rs.getInt("id_categoria");
            }else{
                System.out.println("Categoria no encontrada:"+ nombreCategoria);
            }
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error al obtener categoria");
        }
        return id_categoria;
    }
    public void guardar(Producto p) {
        try (Connection con = Conexion.getConnection()) {
            String sql = "INSERT INTO productos (nombre, precio, id_categoria, stock) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.nombre);
            ps.setDouble(2, p.precio);
            ps.setInt(3, p.id_categoria);
            ps.setInt(4, p.stock);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar producto: " + e.getMessage());
        }
    }
    public boolean editar(Producto p){
        boolean update = false;
        try (Connection con = Conexion.getConnection()){
            String sql = "UPDATE productos set nombre=?,precio=?,id_categoria=?, stock=? "
                    + "WHERE id_producto=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.nombre);
            ps.setDouble(2, p.precio);
            ps.setInt(3, p.id_categoria);
            ps.setInt(4, p.stock);
            ps.setInt(5, p.codigo);
            if(ps.executeUpdate()>0){
                update=true;
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al actualizar producto: " + e.getMessage());
        }
        return update;
    }
    public boolean borrar (Producto p){
        boolean delete = false;
        try(Connection con = Conexion.getConnection()){
            String sql=("DELETE FROM productos WHERE id_producto=? ");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, p.codigo);
            
            if (ps.executeUpdate() > 0) {
                delete = true;
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al borrar producto: " + e.getMessage());
        }
        return delete;
    }
    public Vector<Producto> mostrar() {
        Vector<Producto> lista = new Vector<>();
        try (Connection con = Conexion.getConnection()) {
            String sql = "SELECT p.id_producto, p.nombre, p.precio, c.nombre as categoria, p.stock FROM productos p "
                    + "INNER JOIN categoria c on p.id_categoria=c.id_categoria";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto(
                    rs.getInt("id_producto"),    
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    rs.getString("categoria"),
                    rs.getInt("stock")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar productos: " + e.getMessage());
        }
        return lista;
    }
}