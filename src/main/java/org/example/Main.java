package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Optional;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductoController productoController = new ProductoController();
        ClienteController clienteController= new ClienteController();
        boolean menu_while = true;
        while (menu_while) {
            System.out.println("Ingrese que desee hacer");
            System.out.println("1-Gestionar productos");
            System.out.println("2-Gestionar clientes");
            int menuSwitch = scanner.nextInt();
            scanner.nextLine();
            switch (menuSwitch){
            case 1:{productoController.iniciarProductoController();
                    break;
            }
            case 2:{
                    clienteController.iniciarClienteController();
                    break;

            }

            }

        }
    }
}