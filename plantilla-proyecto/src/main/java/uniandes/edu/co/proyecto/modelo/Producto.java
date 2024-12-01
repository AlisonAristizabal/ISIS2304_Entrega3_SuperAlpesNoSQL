package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "producto")
@ToString
public class Producto {
    @Id
    private String _id;
    private int id;
    private String nombre;
    private int costo_bodega;
    private int precio_unidad;
    private String presentacion;
    private int cantidad_presentacion;
    private double volumen;
    private double peso_empaque;
    private String unidad_medida;
    private String codigo_barras;
    private Date fecha_expiracion;
    private int id_categoria;

    public Producto() {
    }

    public Producto(int id, String nombre, int costo_bodega, int precio_unidad, String presentacion,
            int cantidad_presentacion, double volumen, double peso_empaque, String unidad_medida, String codigo_barras,
            Date fecha_expiracion, int id_categoria) {
        this.id = id;
        this.nombre = nombre;
        this.costo_bodega = costo_bodega;
        this.precio_unidad = precio_unidad;
        this.presentacion = presentacion;
        this.cantidad_presentacion = cantidad_presentacion;
        this.volumen = volumen;
        this.peso_empaque = peso_empaque;
        this.unidad_medida = unidad_medida;
        this.codigo_barras = codigo_barras;
        this.fecha_expiracion = fecha_expiracion;
        this.id_categoria = id_categoria;
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

    public int getCosto_bodega() {
        return costo_bodega;
    }

    public void setCosto_bodega(int costo_bodega) {
        this.costo_bodega = costo_bodega;
    }

    public int getPrecio_unidad() {
        return precio_unidad;
    }

    public void setPrecio_unidad(int precio_unidad) {
        this.precio_unidad = precio_unidad;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public int getCantidad_presentacion() {
        return cantidad_presentacion;
    }

    public void setCantidad_presentacion(int cantidad_presentacion) {
        this.cantidad_presentacion = cantidad_presentacion;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public double getPeso_empaque() {
        return peso_empaque;
    }

    public void setPeso_empaque(double peso_empaque) {
        this.peso_empaque = peso_empaque;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public String getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public Date getFecha_expiracion() {
        return fecha_expiracion;
    }

    public void setFecha_expiracion(Date fecha_expiracion) {
        this.fecha_expiracion = fecha_expiracion;
    }

    public int getCodigo_categoria() {
        return id_categoria;
    }

    public void setCodigo_categoria(int codigo_categoria) {
        this.id_categoria = codigo_categoria;
    }

}
