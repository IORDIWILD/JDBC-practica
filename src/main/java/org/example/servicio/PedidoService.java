package org.example.servicio;

import org.example.conexion.ConexionDB;
import org.example.dao.DetallePedidoDAO;
import org.example.dao.PedidoDAO;
import org.example.modelo.DetallePedido;
import org.example.modelo.Pedido;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PedidoService {

    private final PedidoDAO pedidoDAO = new PedidoDAO();
    private final DetallePedidoDAO detalleDAO = new DetallePedidoDAO();

    public void crearPedidoConDetalles(Pedido pedido, List<DetallePedido> detalles) throws SQLException {
        Connection conn = null;

        try {
            conn = ConexionDB.getConexionDB();
            conn.setAutoCommit(false); // arranca la transacción

            int idPedidoGenerado = pedidoDAO.insertar(pedido, conn);

            for (DetallePedido detalle : detalles) {
                detalle.setId_pedido(idPedidoGenerado); // le asigna el id recién generado
                detalleDAO.insertar(detalle, conn);
            }

            conn.commit();
            System.out.println("Pedido #" + idPedidoGenerado + " creado con " + detalles.size() + " detalle(s).");

        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback();
                System.out.println("Se hizo rollback: " + e.getMessage());
            }
            throw e; // re-lanza el error para que el Manager se entere

        } finally {
            if (conn != null) {
                conn.setAutoCommit(true); // vuelve al modo normal
                conn.close(); // acá sí cerramos manualmente, porque no usamos try-with-resources
            }
        }
    }
}