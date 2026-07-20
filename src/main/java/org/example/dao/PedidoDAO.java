package org.example.dao;
import org.example.modelo.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class PedidoDAO{

    public int insertar(Pedido pedido, Connection conn) throws SQLException {
        String sql = "INSERT INTO pedido(id_cliente, id_empleado, fecha_pedido, estado) VALUES (?,?,?,?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, pedido.getId_cliente());
            stmt.setInt(2, pedido.getId_empleado());
            stmt.setString(3, pedido.getFecha_pedido());
            stmt.setString(4, pedido.getEstado());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        throw new SQLException("No se pudo obtener el id del pedido insertado.");
    }
}




