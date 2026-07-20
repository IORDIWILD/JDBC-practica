package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Optional;

import org.example.gestor.EmpleadoManager;
import org.example.gestor.ProductoManager;
import org.example.modelo.Cliente;
import org.example.modelo.Producto;
import org.example.gestor.ClienteManager;
public class Main {
    public static void main(String[] args) {
        ClienteManager clienteManager = new ClienteManager();
        clienteManager.iniciarClienteManager();
    }
}