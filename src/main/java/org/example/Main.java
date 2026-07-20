package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Optional;

import org.example.gestor.EmpleadoManager;
import org.example.gestor.ProductoManager;
import org.example.modelo.Producto;

public class Main {
    public static void main(String[] args) {
        EmpleadoManager empleadoManager = new EmpleadoManager();
        empleadoManager.iniciarEmpleadoManager();
    }
}