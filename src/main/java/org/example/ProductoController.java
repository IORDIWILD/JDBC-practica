package org.example;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class ProductoController {


    public ProductoController() {
    }

    public void iniciarProductoController() {

        Scanner scanner = new Scanner(System.in);
        ProductoDAO productodao = new ProductoDAO();
        boolean menu_while = true;
        while (menu_while) {
            System.out.println("Ingrese que desee hacer");
            System.out.println("1-Insertar Producto");
            System.out.println("2-Borrar Producto");
            System.out.println("3-Listar Productos");
            System.out.println("4-Buscar Productos");
            System.out.println("5-Modificar Producto");
            System.out.println("6-Salir al Menu principal");
            int menu_switch = scanner.nextInt();
            scanner.nextLine();
            switch (menu_switch) {
                case 1: {
                    System.out.println("Ingrese el Nombre, id de la categoria y el precio en el orden que se dicto");
                    String nombre = scanner.nextLine();
                    int id_categoria = scanner.nextInt();
                    double precio = scanner.nextDouble();
                    scanner.nextLine();

                    Producto producto = new Producto(id_categoria, nombre, precio);
                    productodao.insertarProducto(producto);
                    break;

                }
                case 2: {
                    System.out.println("Ingrese el id del producto a borrar");
                    int id_producto = scanner.nextInt();
                    scanner.nextLine();
                    productodao.borrarProducto(id_producto);
                    break;

                }
                case 3: {
                    ArrayList<Producto> productos;
                    productos = productodao.listProductos();
                    for (Producto producto : productos) {
                        System.out.println(producto);
                    }
                    break;

                }
                case 4: {
                    System.out.println("Ingrese el nombre del producto");
                    String nombre = scanner.nextLine();
                    Optional<Producto> producto = productodao.buscarPorNombre(nombre);
                    if (producto.isPresent()) {
                        System.out.println(producto.get());
                    } else {
                        System.out.println("Producto no existente");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Ingrese el id del producto, seguido de su nombre, id_categoria y el precio");
                    int id_producto = scanner.nextInt();
                    scanner.nextLine();
                    String nombre = scanner.nextLine();
                    int id_categoria = scanner.nextInt();
                    double precio = scanner.nextDouble();
                    Producto producto = new Producto(id_producto, id_categoria, nombre, precio);
                    productodao.modificarProducto(producto);
                }
                default:{
                    menu_while=false;
                    break;

                }

            }

        }
    }
}










