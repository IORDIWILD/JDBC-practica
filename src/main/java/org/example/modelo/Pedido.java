package org.example.modelo;

public class Pedido {
    private int id_pedido;
    private int id_cliente;
    private int id_empleado;
    private String fecha_pedido;
    private String estado;

    public Pedido(int id_pedido, int id_cliente, int id_empleado, String fecha_pedido, String estado) {
        this.id_pedido = id_pedido;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
        this.fecha_pedido = fecha_pedido;
        this.estado = estado;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(String fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
