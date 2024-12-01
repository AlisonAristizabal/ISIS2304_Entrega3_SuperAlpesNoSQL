package uniandes.edu.co.proyecto.modelo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.ToString;

@ToString
public class ProductoOrdenCompra {
    @Id
    private String _id;
    private int cantidad;
    private int precio;
    private ObjectId id_producto;

    public ProductoOrdenCompra(String _id, int cantidad, int precio, ObjectId id_producto) {
        this._id = _id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.id_producto = id_producto;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public ObjectId getId_producto() {
        return id_producto;
    }

    public void setId_producto(ObjectId id_producto) {
        this.id_producto = id_producto;
    }

}
