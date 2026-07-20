package org.example.gestor;


import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import org.example.dao.EmpleadoDAO;
import org.example.modelo.Empleado;

public class EmpleadoManager {
    public EmpleadoManager() {
    }

    public void iniciarEmpleadoManager(){
        Scanner scanner = new Scanner(System.in);
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        boolean menuWhile = true;
        while (menuWhile){
            System.out.println("Ingrese que desee hacer:");
            System.out.println("1- Listar Empleados");
            System.out.println("2- Insertar Empleado");
            System.out.println("3- Actualizar Empleado");
            System.out.println("4- Borrar Empleado");
            System.out.println("5- Buscar Empleado");
            System.out.println("6- Volver al menu principal");
            int menuSwitch = scanner.nextInt();
            scanner.nextLine();
            switch (menuSwitch){
                case 1:{
                    try {
                        ArrayList<Empleado> empleados = empleadoDAO.listar();
                        for(Empleado empleado : empleados){
                            System.out.println(empleado);
                        }
                    }catch(SQLException e){
                        System.out.println("error al buscar empleado "+ e.getMessage());
                    }
                    break;
                }
                case 2:{
                    System.out.println("Ingrese el nombre del empleado");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el puesto del empleado");
                    String puesto = scanner.nextLine();
                    System.out.println("Ingrese el salario del empleado");
                    double salario = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Ingrese el id del Jefe");
                    int jefe_id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese la fecha de contratacion");
                    String fecha_contratacion = scanner.nextLine();
                    Empleado empleado = new Empleado(nombre,puesto,salario,jefe_id,fecha_contratacion);
                    try{
                        empleadoDAO.insertar(empleado);
                        System.out.println("Empleado insertado correctamente");
                    }catch(SQLException e){
                        System.out.println("Error al insertar empleado "+ e.getMessage());
                    }
                    break;
                }
                case 3:{
                    System.out.println("Ingrese el id del empleado");
                    int id_empleado = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el nombre del empleado");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el puesto del empleado");
                    String puesto = scanner.nextLine();
                    System.out.println("Ingrese el salario del empleado");
                    double salario = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Ingrese el id del Jefe");
                    int jefe_id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese la fecha de contratacion");
                    String fecha_contratacion = scanner.nextLine();
                    Empleado empleado = new Empleado(id_empleado, nombre,puesto,salario,jefe_id,fecha_contratacion);
                    try{
                        empleadoDAO.actualizar(empleado);
                        System.out.println("Empleado actualizado correctamente");
                    }catch(SQLException e){
                        System.out.println("Error al actualizar empleado "+e.getMessage());
                    }
                    break;
                }
                case 4:{
                    System.out.println("Ingrese el id del empleado a borrar");
                    int id_empleado = scanner.nextInt();
                    try{
                        empleadoDAO.borrar(id_empleado);
                        System.out.println("Empleado borrado exitosamente");

                    }catch(SQLException e){
                        System.out.println("error al borrar empleado " + e.getMessage());
                    }
                    break;
                }
                case 5:{
                    System.out.println("Ingrese el id del empleado a buscar");
                    int id_empleado = scanner.nextInt();
                    scanner.nextLine();
                    try{
                        Optional<Empleado> empleado = empleadoDAO.buscarPorId(id_empleado);
                        if(empleado.isPresent()){
                            System.out.println(empleado.get());
                        }else{
                            System.out.println("Empleado no encontrado");
                        }

                    }catch(SQLException e){
                        System.out.println("Error al buscar empleado");
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
