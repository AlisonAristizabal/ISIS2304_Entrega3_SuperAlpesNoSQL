package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "producto")
@ToString
public class Producto {
    @Id
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
    private Categoria categoria;

}
