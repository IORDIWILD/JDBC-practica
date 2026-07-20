package org.example.dao;

import org.example.conexion.ConexionDB;
import org.example.modelo.DetallePedido;
import java.sql.*;

public class DetallePedidoDAO {

    // También recibe la Connection por parámetro
    public void insertar(DetallePedido detalle, Connection conn) throws SQLException {
        String sql = "INSERT INTO detalle_pedido(id_pedido, id_producto, cantidad, precio_unitario) VALUES (?,?,?,?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, detalle.getId_pedido());
            stmt.setInt(2, detalle.getId_producto());
            stmt.setInt(3, detalle.getCantidad());
            stmt.setDouble(4, detalle.getPrecio_unitario());
            stmt.executeUpdate();
        }
    }
}