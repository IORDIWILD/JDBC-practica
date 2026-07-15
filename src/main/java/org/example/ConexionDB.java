package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionDB
{
    private static final String URL = "jdbc:mariadb://localhost:3306/practica";
    private static final String USUARIO = "estudiante";
    private static final String PASSWORD = "123";


    public static Connection getConexionDB() throws SQLException {
        return DriverManager.getConnection(URL,USUARIO,PASSWORD);
    }

}
