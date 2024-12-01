package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;

import lombok.ToString;

@ToString
public class ProductosEnBodega {
    @Id
    private String _id;
    private String id_producto;
    private int cantidad;
    private double costoPromedio;
    private int minimoReorden;

    public ProductosEnBodega(String id_producto, int cantidad, double costoPromedio, int minimoReorden) {
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.costoPromedio = costoPromedio;
        this.minimoReorden = minimoReorden;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCostoPromedio() {
        return costoPromedio;
    }

    public void setCostoPromedio(double costoPromedio) {
        this.costoPromedio = costoPromedio;
    }

    public int getMinimoReorden() {
        return minimoReorden;
    }

    public void setMinimoReorden(int minimoReorden) {
        this.minimoReorden = minimoReorden;
    }

}
