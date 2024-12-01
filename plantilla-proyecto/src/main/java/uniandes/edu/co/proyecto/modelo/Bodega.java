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
    private int id;
    private String nombre;
    private double tamanio;
    private int id_sucursal;
    private List<ProductosEnBodega> productos_en_bodega;

    public Bodega(int id, String nombre, double tamanio, int id_sucursal, List<ProductosEnBodega> productosEnBodega) {
        this.id = id;
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.id_sucursal = id_sucursal;
        this.productos_en_bodega = productosEnBodega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public List<ProductosEnBodega> getProductosEnBodega() {
        return productos_en_bodega;
    }

    public void setProductosEnBodega(List<ProductosEnBodega> productosEnBodega) {
        this.productos_en_bodega = productosEnBodega;
    }

}
