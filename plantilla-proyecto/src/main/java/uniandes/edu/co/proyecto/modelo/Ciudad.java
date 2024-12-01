package uniandes.edu.co.proyecto.modelo;

import lombok.ToString;

@ToString
public class Ciudad {
    private String id_ciudad;
    private String nombre;

    public Ciudad(String id_ciudad, String nombre) {
        this.id_ciudad = id_ciudad;
        this.nombre = nombre;
    }

    public String getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(String id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
