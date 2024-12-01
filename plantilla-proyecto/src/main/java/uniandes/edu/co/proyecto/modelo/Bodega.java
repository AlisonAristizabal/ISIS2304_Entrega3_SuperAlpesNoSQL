package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "bodega")
@ToString
public class Bodega {
    @Id
    private String _id;
    private String nombre;
    private double tamanio;
    private String id_sucursal;
    private List<ProductosEnBodega> productos_en_bodega;

    public Bodega(String _id, String nombre, double tamanio, String id_sucursal,
            List<ProductosEnBodega> productosEnBodega) {
        this._id = _id;
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.id_sucursal = id_sucursal;
        this.productos_en_bodega = productosEnBodega;
    }

    public String getId() {
        return this._id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    public String getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(String id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public List<ProductosEnBodega> getProductosEnBodega() {
        return productos_en_bodega;
    }

    public void setProductosEnBodega(List<ProductosEnBodega> productosEnBodega) {
        this.productos_en_bodega = productosEnBodega;
    }

}
