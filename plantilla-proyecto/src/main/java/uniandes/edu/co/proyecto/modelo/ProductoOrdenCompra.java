package uniandes.edu.co.proyecto.modelo;

import lombok.ToString;

@ToString
public class ProductoOrdenCompra {
    private int cantidad;
    private int precio;
    private String id_producto;

    public ProductoOrdenCompra(int cantidad, int precio, String id_producto) {
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

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

}
