package uniandes.edu.co.proyecto.modelo;

import lombok.ToString;

@ToString
public class Categoria {
    
    private int codigo;
    private String nombre;
    private String descripcion;
    private String caracteristica_almacenamiento;
    
    public Categoria(int codigo, String nombre, String descripcion, String caracteristica_almacenamiento) {
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
    
}
