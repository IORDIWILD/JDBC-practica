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


                }catch(SQLException e){

                }



            }
        }




        }
    }



}
