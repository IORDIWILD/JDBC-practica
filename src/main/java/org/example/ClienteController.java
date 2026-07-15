package org.example;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
public class ClienteController {


    public void iniciarClienteController(){
        ClienteDAO clientedao = new ClienteDAO();

        Scanner scanner = new Scanner(System.in);
        boolean menuWhile=true;
        while(menuWhile) {
        System.out.println("Ingrese que desee hacer:");
        System.out.println("1- Listar Clientes");
        System.out.println("2- Insertar Cliente");
        System.out.println("3- Borrar Cliente");
        System.out.println("4- Buscar Cliente");

            int menuSwitch = scanner.nextInt();
        scanner.nextLine();
        switch(menuSwitch){
            case 1:{
                try {
                    ArrayList<Cliente> clientes = clientedao.listarClientes();
                    for(Cliente cliente : clientes){
                        System.out.println(cliente);
                    }

                }catch(SQLException e) {
                    System.out.println("Error al listar clientes " + e.getMessage());
                }
                break;

            }
            case 2:{
                System.out.println("Ingrese el nombre, email, ciudad, fecha de registrom y telefono en el orden dictado");
                String nombre = scanner.nextLine();
                String email = scanner.nextLine();
                String ciudad = scanner.nextLine();
                String fechaRegistro = scanner.nextLine();
                String telefono = scanner.nextLine();
                Cliente cliente  = new Cliente(nombre,email,ciudad,fechaRegistro,telefono);
                try{
                    Optional<Integer> idGenerado = clientedao.insertarCliente(cliente);
                    if(idGenerado.isPresent()){
                        System.out.println("Se agrego correctamente el cliente con id generado :" + idGenerado.get());
                    }
                    else{
                        System.out.println("No se pudo generar ningun id");
                    }
                }catch(SQLException e){
                    System.out.println("Error al intentar agregar cliente "+ e.getMessage());
                }

                break;
            }
            case 3:{
                System.out.println("Ingrese el id del cliente a borrar");
                int idCliente = scanner.nextInt();
                scanner.nextLine();
                try{
                clientedao.borrarCliente(idCliente);
                System.out.println("Cliente borrado Exitosamente");}
                catch(SQLException e){
                    System.out.println("Error al intentar borrar Cliente " + e.getMessage());
                }
                break;
            }
            case 4:{
                System.out.println("Ingrese el nombre del cliente a buscar");
                String nombre = scanner.nextLine();
                try{
                   Optional<Cliente> cliente = clientedao.buscarClienteNombre(nombre);
                    if(cliente.isPresent()){
                        System.out.println(cliente.get());
                    }else{
                        System.out.println("No se encontro ningun cliente");
                    }

                }catch(SQLException e){

                    System.out.println("Error al buscar cliente " + e.getMessage());
                }
                break;
            }
        }




        }
    }



}
