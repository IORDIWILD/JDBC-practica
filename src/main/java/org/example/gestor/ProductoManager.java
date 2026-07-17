package org.example.gestor;
import org.example.dao.ProductoDAO;
import org.example.modelo.Producto;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class ProductoManager {

    public ProductoManager() {
    }

    public void iniciarProductoManager(){
     Scanner  scanner = new Scanner(System.in);
     ProductoDAO productoDAO = new ProductoDAO();
     boolean menuWhile = true;
     while(menuWhile) {
         System.out.println("Ingrese que desee hacer:");
         System.out.println("1- Listar productos");
         System.out.println("2- Insertar Producto");
         System.out.println("3- Actualizar Producto");
         System.out.println("4- Borrar Producto");
         System.out.println("5- Buscar Producto");
         System.out.println("6- Volver al menu principal");
         int menuSwitch = scanner.nextInt();
         scanner.nextLine();
         switch(menuSwitch){
             case 1:{
                 try{
                     ArrayList<Producto> productos = productoDAO.listar();
                     for(Producto producto : productos){
                         System.out.println(producto);
                     }
                 }catch(SQLException e){

                     System.out.println("Error al listar productos " +e.getMessage());
                 }
                 break;
             }
             case 2:{
                 System.out.println("Ingrese el nombre del producto");
                 String nombre = scanner.nextLine();
                 System.out.println("Ingrese el id de la categoria del producto");
                 int id_categoria = scanner.nextInt();
                 scanner.nextLine();
                 System.out.println("Ingrese el precio del producto");
                 double precio = scanner.nextDouble();
                 Producto producto = new Producto(nombre,id_categoria,precio);
                 try{
                     productoDAO.insertar(producto);
                     System.out.println("Producto insertado correctamente");
                 }catch(SQLException e){
                     System.out.println("Error al insertar producto  "+ e.getMessage());
                 }
                 break;
             }
             case 3:{
                 System.out.println("Ingrese el ID del producto");
                 int id_producto = scanner.nextInt();
                 scanner.nextLine();
                 System.out.println("Ingrese el nombre del producto");
                 String nombre = scanner.nextLine();
                 System.out.println("Ingrese el id de la categoria del producto");
                 int id_categoria = scanner.nextInt();
                 scanner.nextLine();
                 System.out.println("Ingrese el precio del producto");
                 double precio = scanner.nextDouble();
                 Producto producto = new Producto(id_producto,nombre,id_categoria,precio);
                 try{
                     productoDAO.actualizar(producto);
                     System.out.println("Producto actualizado correctamente");
                 }catch(SQLException e){
                     System.out.println("Error al actualizar producto " + e.getMessage());
                 }

                break;
             }
             case 4:{
                 System.out.println("Ingrese el ID del producto ");
                 int id_producto = scanner.nextInt();
                 scanner.nextLine();
                 try{
                     productoDAO.borrar(id_producto);
                     System.out.println("Producto borrado correctamente");
                 }catch(SQLException e){

                     System.out.println("Error al borrar producto "+ e.getMessage());
                 }

                 break;
             }
             case 5:{
                 System.out.println("Ingrese el ID del producto ");
                 int id_producto = scanner.nextInt();
                 scanner.nextLine();
                 try{
                    Optional<Producto> producto =  productoDAO.buscarPorId(id_producto);
                    if(producto.isPresent()){
                    System.out.println(producto.get());
                    }else{
                        System.out.println("No se encontro ningun producto");
                    }

                 }catch(SQLException e){
                     System.out.println("Error al buscar producto "+ e.getMessage());
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
