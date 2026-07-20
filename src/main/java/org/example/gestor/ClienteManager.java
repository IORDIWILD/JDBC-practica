package org.example.gestor;

import java.awt.desktop.SystemEventListener;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import org.example.dao.ClienteDAO;
import org.example.dao.ProductoDAO;
import org.example.modelo.Cliente;

public class ClienteManager {

    public ClienteManager() {
    }

    public void iniciarClienteManager(){
        Scanner scanner = new Scanner(System.in);
        boolean menuWhile = true;
        ClienteDAO clienteDAO = new ClienteDAO();
        while(menuWhile){
            System.out.println("Ingrese que desee hacer:");
            System.out.println("1- Listar Clientes");
            System.out.println("2- Insertar Cliente");
            System.out.println("3- Actualizar Cliente");
            System.out.println("4- Borrar Cliente");
            System.out.println("5- Buscar Cliente");
            System.out.println("6- Volver al menu principal");
            int menuSwitch = scanner.nextInt();
            scanner.nextLine();
            switch(menuSwitch){
                case 1:{
                    try {
                        ArrayList<Cliente> clientes = clienteDAO.listar();
                        for(Cliente cliente : clientes){
                            System.out.println(cliente);
                        }
                    }catch(SQLException e){
                        System.out.println("Error al listar clientes "+ e.getMessage());
                    }
                    break;
                }
                case 2:{
                    System.out.println("Ingrese el nombre del cliente");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el email del cliente");
                    String email = scanner.nextLine();
                    System.out.println("Ingrese la ciudad del cliente");
                    String ciudad = scanner.nextLine();
                    System.out.println("Ingrese la fecha de registro del cliente");
                    String fecha_registro = scanner.nextLine();
                    System.out.println("Ingrese el telefono del cliente");
                    String telefono = scanner.nextLine();
                    Cliente cliente = new Cliente(nombre,email,ciudad,fecha_registro,telefono);
                    try{
                        clienteDAO.insertar(cliente);
                        System.out.println("Cliente insertado correctamente");
                    }catch(SQLException e){
                        System.out.println("Error al insertar cliente " + e.getMessage());
                    }
                    break;
                }
                case 3:{
                    System.out.println("Ingrese el id del cliente");
                    int id_cliente = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el nombre del cliente");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el email del cliente");
                    String email = scanner.nextLine();
                    System.out.println("Ingrese la ciudad del cliente");
                    String ciudad = scanner.nextLine();
                    System.out.println("Ingrese la fecha de registro del cliente");
                    String fecha_registro = scanner.nextLine();
                    System.out.println("Ingrese el telefono del cliente");
                    String telefono = scanner.nextLine();
                    Cliente cliente = new Cliente(id_cliente,nombre,email,ciudad,fecha_registro,telefono);
                    try{
                        clienteDAO.actualizar(cliente);
                        System.out.println("Cliente actualizado correctamente");
                    }catch(SQLException e){
                        System.out.println("Error al actualizar cliente" + e.getMessage());
                    }
                    break;
                }
                case 4:{
                    System.out.println("Ingrese el id del cliente");
                    int id_cliente = scanner.nextInt();
                    scanner.nextLine();
                    try{
                        clienteDAO.borrar(id_cliente);
                        System.out.println("Cliente borrado exitosamente");
                    }catch(SQLException e){
                        System.out.println("Error al buscar cliente" + e.getMessage());
                    }
                    break;
                }
                case 5:{
                    System.out.println("Ingrese el id del cliente");
                    int id_cliente = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        Optional<Cliente> cliente = clienteDAO.buscarPorId(id_cliente);
                        if(cliente.isPresent()){
                            System.out.println(cliente.get());
                        }else{
                            System.out.println("Cliente no encontrado");
                        }
                    }catch(SQLException e){
                        System.out.println("Error al buscar cliente " + e.getMessage());
                    }
                    break;

                }
                default:{
                    menuWhile=false;
                    break;
                }
            }






        }


    }




}
