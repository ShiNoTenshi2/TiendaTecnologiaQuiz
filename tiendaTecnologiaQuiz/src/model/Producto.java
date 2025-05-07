package model;

public class Producto {
    private int referencia;  // Identificador único del producto
    private String nombre;   // Nombre del producto
    private double precio;   // Precio del producto
    private int cantidad;    // Cantidad disponible en inventario

    // Constructor que inicializa los atributos del producto
    public Producto(int referencia, String nombre, double precio, int cantidad) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Métodos getter y setter para acceder y modificar los atributos

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
