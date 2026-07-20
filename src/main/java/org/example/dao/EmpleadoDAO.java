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

    public EmpleadoDAO() {
    }

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
        String sql = "INSERT INTO empleado(nombre,puesto,salario,jefe_id,fecha_contratacion) VALUES(?,?,?,?,?)";
        try(Connection conn = ConexionDB.getConexionDB();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,empleado.getNombre());
            stmt.setString(2,empleado.getPuesto());
            stmt.setDouble(3,empleado.getSalario());
            stmt.setInt(4,empleado.getJefe_id());
            stmt.setString(5,empleado.getFecha_contratacion());
            stmt.executeUpdate();
        }
    }

    @Override
    public void actualizar(Empleado empleado) throws SQLException {
        String sql = "UPDATE empleado SET nombre = ?, puesto = ?, salario = ?, jefe_id = ?, fecha_contratacion = ? WHERE id_empleado = ?";
        try(Connection conn = ConexionDB.getConexionDB();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,empleado.getNombre());
            stmt.setString(2,empleado.getPuesto());
            stmt.setDouble(3,empleado.getSalario());
            stmt.setInt(4,empleado.getJefe_id());
            stmt.setString(5,empleado.getFecha_contratacion());
            stmt.setInt(6,empleado.getId_empleado());
            stmt.executeUpdate();
        }
    }

    @Override
    public void borrar(Integer id_empleado) throws SQLException {
        String sql = "DELETE FROM empleado WHERE id_empleado = ?";
        try(Connection conn = ConexionDB.getConexionDB();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id_empleado);
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Empleado> buscarPorId(Integer id_empleado) throws SQLException {
        String sql = "SELECT * FROM empleado WHERE id_empleado = ?";
        try(Connection conn = ConexionDB.getConexionDB();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id_empleado);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    Empleado empleado = new Empleado(
                            rs.getInt("id_empleado"),
                            rs.getString("nombre"),
                            rs.getString("puesto"),
                            rs.getDouble("salario"),
                            rs.getInt("jefe_id"),
                            rs.getString("fecha_contratacion")
                    );
                    return Optional.of(empleado);
                }
            }
        }
        return Optional.empty();
    }
}
