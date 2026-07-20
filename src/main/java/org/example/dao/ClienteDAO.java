package org.example.dao;
import org.example.conexion.ConexionDB;
import org.example.modelo.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ConcurrentNavigableMap;

public class ClienteDAO implements CrudDAO<Cliente,Integer> {


    public ClienteDAO() {
    }

    @Override
    public ArrayList<Cliente> listar() throws SQLException {
        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try(Connection conn = ConexionDB.getConexionDB();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();){
            while(rs.next()){
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

    @Override
    public void insertar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente(nombre,email,ciudad,fecha_registro,telefono) VALUES (?,?,?,?,?)";
        try(Connection conn = ConexionDB.getConexionDB();
           PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,cliente.getNombre());
            stmt.setString(2,cliente.getEmail());
            stmt.setString(3,cliente.getCiudad());
            stmt.setString(4,cliente.getFechaRegistro());
            stmt.setString(5,cliente.getTelefono());
            stmt.executeUpdate();
        }
    }

    @Override
    public void actualizar(Cliente cliente) throws SQLException {
        String sql = "UPDATE cliente SET nombre = ?, email = ?, ciudad = ?, fecha_registro = ?, telefono = ? WHERE id_cliente = ?";
        try(Connection conn = ConexionDB.getConexionDB();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,cliente.getNombre());
            stmt.setString(2,cliente.getEmail());
            stmt.setString(3,cliente.getCiudad());
            stmt.setString(4,cliente.getFechaRegistro());
            stmt.setString(5,cliente.getTelefono());
            stmt.setInt(6, cliente.getId_cliente());
            stmt.executeUpdate();
        }



    }

    @Override
    public void borrar(Integer id_cliente) throws SQLException {
        String sql = "DELETE from cliente WHERE id_cliente = ?";
        try(Connection conn = ConexionDB.getConexionDB();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id_cliente);
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Cliente> buscarPorId(Integer id_cliente) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        try(Connection conn = ConexionDB.getConexionDB();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id_cliente);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    Cliente cliente = new Cliente(
                            rs.getInt("id_cliente"),
                            rs.getString("nombre"),
                            rs.getString("email"),
                            rs.getString("ciudad"),
                            rs.getString("fecha_registro"),
                            rs.getString("telefono")
                    );
                    return Optional.of(cliente);
                }
            }
        }
        return Optional.empty();
    }
}
