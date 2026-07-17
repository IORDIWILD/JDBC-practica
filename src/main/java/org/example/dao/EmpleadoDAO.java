package org.example.dao;
import org.example.conexion.ConexionDB;
import org.example.modelo.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class EmpleadoDAO implements CrudDAO<Empleado,Integer> {

    @Override
    public ArrayList<Empleado> listar() throws SQLException {
        ArrayList<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * from empleado";
        try(Connection conn = ConexionDB.getConexionDB();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                Empleado empleado = new Empleado(
                        rs.getInt("id_empleado"),
                        rs.getString("nombre"),
                        rs.getString("puesto"),
                        rs.getDouble("salario"),
                        rs.getInt("jefe_id"),
                        rs.getString("fecha_contratacion")
                );
                empleados.add(empleado);
            }
        }
        return empleados;
    }

    @Override
    public void insertar(Empleado empleado) throws SQLException {





    }

    @Override
    public void actualizar(Empleado empleado) throws SQLException {

    }

    @Override
    public void borrar(Integer id_empleado) throws SQLException {


    }

    @Override
    public Optional<Empleado> buscarPorId(Integer id_empleado) throws SQLException {
        return Optional.empty();
    }
}
