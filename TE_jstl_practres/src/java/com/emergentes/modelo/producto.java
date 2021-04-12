package com.emergentes.modelo;

public class producto {

    private int id;
    private String producto;
    private double precio;
    private int cantidad;

    public producto() {
        id = 0;
        producto = "";
        precio = 0;
        cantidad = 0;
    }

    public producto(int id, String producto, double precio, int cantidad) {
        this.id = id;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public String getProducto() {
        return producto;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
