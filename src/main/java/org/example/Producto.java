package org.example;

public class Producto {
    private int id;
    private int id_categoria;
    private String nombre;
    private double precio;

    public Producto(){
    }
    public Producto(int id, int id_categoria, String nombre, double precio){
        this.id= id;
        this.id_categoria=id_categoria;
        this.nombre=nombre;
        this.precio=precio;
    }
    public Producto(int id_categoria, String nombre, double precio){
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Producto{id=" + id + ", nombre='" + nombre + "', id_categoria=" + id_categoria
                + ", precio=" + precio +"}";
    }


}
