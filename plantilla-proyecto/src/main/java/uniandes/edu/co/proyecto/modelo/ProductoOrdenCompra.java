package uniandes.edu.co.proyecto.modelo;

import lombok.ToString;

@ToString
public class ProductoOrdenCompra {
    private int cantidad;
    private int precio;
    private int id_producto;

    public ProductoOrdenCompra(int cantidad, int precio, int id_producto) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

}
