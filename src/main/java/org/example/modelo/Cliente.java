package org.example.modelo;

public class Cliente {
    private int id_cliente;
    private String nombre;
    private String email;
    private String ciudad;
    private String fecha_registro;
    private String telefono;

    public Cliente(String nombre, String email, String ciudad, String fechaRegistro, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.ciudad = ciudad;
        this.fecha_registro = fechaRegistro;
        this.telefono = telefono;
    }

    public Cliente(int id_cliente, String nombre, String email, String ciudad, String fechaRegistro, String telefono) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.email = email;
        this.ciudad = ciudad;
        this.fecha_registro = fechaRegistro;
        this.telefono = telefono;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFechaRegistro() {
        return fecha_registro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fecha_registro = fechaRegistro;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{id=" + id_cliente + ", nombre='" + nombre + "', email=" + email
                + ", ciudad=" + ciudad +"}" + ", fecha de registro=" + fecha_registro +", telefono="+telefono+"}";
    }
}
