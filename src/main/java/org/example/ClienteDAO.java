package org.example;

import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class ClienteDAO {

    public ClienteDAO() {
    }

    public ArrayList<Cliente> listarClientes() throws SQLException {
        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection conn = ConexionDB.getConexionDB();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("ciudad"),
                        rs.getString("fecha_registro"),
                        rs.getString("telefono")
                );
                clientes.add(cliente);
            }
        }
        return clientes;

    }

    public Optional<Integer> insertarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nombre,email,ciudad,fecha_registro,telefono) VALUES (?,?,?,?,?)";

        try (Connection conn = ConexionDB.getConexionDB();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCiudad());
            stmt.setString(4, cliente.getFechaRegistro());
            stmt.setString(5, cliente.getTelefono());
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas == 0) {
                return Optional.empty();
            }

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int idGenerado = rs.getInt(1);
                    return Optional.of(idGenerado);
                } else {
                    return Optional.empty();
                }
            }

        }
    }

    public void borrarCliente(int idCliente) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        try (Connection conn = ConexionDB.getConexionDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            stmt.executeUpdate();
        }
    }

    public Optional<Cliente> buscarClienteNombre(String nombre) throws SQLException {

        String sql = "SELECT * FROM cliente WHERE nombre = ? ";
        try (Connection conn = ConexionDB.getConexionDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("ciudad"),
                        rs.getString("fecha_registro"),
                        rs.getString("telefono")
                );

                return Optional.of(cliente);
            } else {
                return Optional.empty();
            }
        }


    }

    public void modificarCliente(Cliente cliente){



    }

}
