package org.example.dao;
import org.example.conexion.ConexionDB;
import org.example.modelo.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProductoDAO implements CrudDAO<Producto,Integer> {

    public ProductoDAO() {
    }

    @Override
    public ArrayList<Producto> listar() throws SQLException {
        ArrayList<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto";
        try(Connection conn = ConexionDB.getConexionDB();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                Producto producto = new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getInt("id_categoria"),
                        rs.getDouble("precio")
                );
                productos.add(producto);
            }
        }
        return productos;
    }

    @Override
    public void insertar(Producto producto) throws SQLException {
        String sql = "INSERT INTO producto (nombre,id_categoria,precio) VALUES (?,?,?)";
        try(Connection conn = ConexionDB.getConexionDB();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,producto.getNombre());
            stmt.setInt(2,producto.getId_categoria());
            stmt.setDouble(3,producto.getPrecio());
            stmt.executeUpdate();
        }
    }

    @Override
    public void actualizar(Producto producto) throws SQLException {

        String sql = "UPDATE producto SET nombre = ?, id_categoria = ?, precio = ? WHERE id_producto = ?";
        try(Connection conn = ConexionDB.getConexionDB();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,producto.getNombre());
            stmt.setInt(2,producto.getId_categoria());
            stmt.setDouble(3,producto.getPrecio());
            stmt.setInt(4,producto.getId_producto());
            stmt.executeUpdate();
        }
    }

    @Override
    public void borrar(Integer id_producto) throws SQLException {
        String sql = "DELETE FROM producto WHERE id_producto = ?";
        try(Connection conn = ConexionDB.getConexionDB();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id_producto);
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Producto> buscarPorId(Integer id_producto) throws SQLException {
        String sql = "SELECT * FROM producto WHERE id_producto = ?";
        try(Connection conn = ConexionDB.getConexionDB();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id_producto);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    Producto producto = new Producto(
                            rs.getInt("id_producto"),
                            rs.getString("nombre"),
                            rs.getInt("id_categoria"),
                            rs.getDouble("precio") );

                    return Optional.of(producto);
                }
            }
        }
        return Optional.empty();
    }
}
