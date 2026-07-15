package org.example;

import java.util.ArrayList;
import java.sql.*;
import java.util.Optional;

public class ProductoDAO {

    public ProductoDAO() {
    }

    public ArrayList<Producto>listProductos(){
    ArrayList<Producto> productos = new ArrayList<>();
    String sql ="SELECT * FROM producto;";
    try(    Connection conn = ConexionDB.getConexionDB();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs= stmt.executeQuery();
            ){
        while(rs.next()){
            Producto producto = new Producto(
                    rs.getInt("id_producto"),
                    rs.getInt("id_categoria"),
                    rs.getString("nombre"),
                    rs.getDouble("precio")
            );
        productos.add(producto);
        }

    }catch(SQLException e){

    System.out.println("Error al listar productos: " + e.getMessage());

    }

    return productos;
}

    public void insertarProducto(Producto producto){

        String sql = "INSERT INTO producto(nombre,id_categoria,precio) VALUES(?,?,?);";
        try(Connection conn = ConexionDB.getConexionDB();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getId_categoria());
            stmt.setDouble(3, producto.getPrecio());

            stmt.executeUpdate();
            System.out.println("Producto insertado correctamente");

        }catch(SQLException e){

            System.out.println("Error al insertar productos: " + e.getMessage());

        }
    }

    public void borrarProducto(int id_producto){

        String sql = "DELETE FROM producto WHERE id_producto = ?;";
        try(Connection conn = ConexionDB.getConexionDB();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setInt(1,id_producto);
            stmt.executeUpdate();
            System.out.println("Producto borrado correctamente");
        }catch(SQLException e){

            System.out.println("Error al intentar borrar producto " + e.getMessage());
        }
    }

    public Optional<Producto> buscarPorNombre(String nombre) {
        String sql = "SELECT * FROM producto WHERE nombre = ?;";

        try (Connection conn = ConexionDB.getConexionDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Producto producto = new Producto();
                    producto.setId(rs.getInt("id_producto"));
                    producto.setId_categoria(rs.getInt("id_categoria"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setPrecio(rs.getDouble("precio"));
                    return Optional.of(producto);
                }
            }
        } catch (SQLException e) {
            System.err.println("ERROR al buscar producto: " + e.getMessage());

        }

        return Optional.empty();
    }

    public void modificarProducto(Producto producto){
        String sql = "UPDATE producto SET nombre = ?, id_categoria = ?, precio = ? WHERE id_producto = ? ;";
        try(Connection conn = ConexionDB.getConexionDB();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1,producto.getNombre());
            stmt.setInt(2,producto.getId_categoria());
            stmt.setDouble(3,producto.getPrecio());
            stmt.setInt(4,producto.getId());
            stmt.executeUpdate();
            System.out.println("Producto Actualizado correctamente");

        }catch(SQLException e){
            System.out.println("Error al modificar producto " + e.getMessage());
        }


    }


}

