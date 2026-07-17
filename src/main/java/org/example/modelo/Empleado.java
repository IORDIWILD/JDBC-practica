package org.example.modelo;

public class Empleado {
    private int id_empleado;
    private String nombre;
    private String puesto;
    private double salario;
    private int jefe_id;
    private String fecha_contratacion;

    public Empleado(int id_empleado, String nombre, String puesto, double salario, int jefe_id, String fecha_contratacion) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.jefe_id = jefe_id;
        this.fecha_contratacion = fecha_contratacion;
    }

    public Empleado(String nombre, String puesto, double salario, int jefe_id, String fecha_contratacion) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.jefe_id = jefe_id;
        this.fecha_contratacion = fecha_contratacion;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getJefe_id() {
        return jefe_id;
    }

    public void setJefe_id(int jefe_id) {
        this.jefe_id = jefe_id;
    }

    public String getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(String fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    @Override
    public String toString(){
        return "Empleado{id=" + id_empleado + ", nombre='" + nombre + "', puesto=" +puesto
                + ", salario=" + salario +"}" + ", id del jefe=" + jefe_id +", fecha de contratacion="+fecha_contratacion+"}";
    }
}
