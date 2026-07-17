package org.example.modelo;

public class Producto {
    private int id_producto;
    private int id_categoria;
    private String nombre;
    private double precio;

    public Producto(){
    }
    public Producto(int id_producto, String nombre, int id_categoria, double precio){
        this.id_producto= id_producto;
        this.id_categoria=id_categoria;
        this.nombre=nombre;
        this.precio=precio;
    }
    public Producto(String nombre, int id_categoria, double precio){
        this.id_categoria=id_categoria;
        this.nombre=nombre;
        this.precio=precio;
    }


    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId(int id) {
        this.id_producto = id;
    }

    @Override
    public String toString() {
        return "Producto{id=" + id_producto + ", nombre='" + nombre + "', id_categoria=" + id_categoria
                + ", precio=" + precio +"}";
    }


}

