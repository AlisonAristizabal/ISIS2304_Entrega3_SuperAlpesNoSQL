package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "categoria")
@CompoundIndexes({
    @CompoundIndex(name = "codigo_unique", def = "{'codigo': 1}", unique = true)
})
@ToString
public class Categoria {

    @Id
    private int id;
    private int codigo;
    private String nombre;
    private String descripcion;
    private String caracteristica_almacenamiento;
    
    public Categoria() {
    }

    public Categoria(int id, int codigo, String nombre, String descripcion, String caracteristica_almacenamiento) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.caracteristica_almacenamiento = caracteristica_almacenamiento;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristica_almacenamiento() {
        return caracteristica_almacenamiento;
    }

    public void setCaracteristica_almacenamiento(String caracteristica_almacenamiento) {
        this.caracteristica_almacenamiento = caracteristica_almacenamiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
