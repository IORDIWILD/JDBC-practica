package org.example.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public interface CrudDAO<T,ID> {
    ArrayList<T> listar() throws SQLException;
    void insertar(T entidad) throws  SQLException;
    void actualizar(T entidad) throws SQLException;
    void borrar(ID id) throws SQLException;
    Optional<T> buscarPorId(ID id) throws SQLException;
}
