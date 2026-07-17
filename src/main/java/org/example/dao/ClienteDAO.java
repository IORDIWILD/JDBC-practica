package org.example.dao;
import org.example.modelo.Cliente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class ClienteDAO implements CrudDAO<Cliente,Integer> {

    @Override
    public ArrayList<Cliente> listar() throws SQLException {
        return null;
    }

    @Override
    public void insertar(Cliente cliente) throws SQLException {

    }

    @Override
    public void actualizar(Cliente cliente) throws SQLException {

    }

    @Override
    public void borrar(Integer id_cliente) throws SQLException {

    }

    @Override
    public Optional<Cliente> buscarPorId(Integer id_cliente) throws SQLException {
        return Optional.empty();
    }
}
