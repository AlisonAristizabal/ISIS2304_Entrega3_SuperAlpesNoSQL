package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "proveedor")
@ToString
public class Proveedor {
    @Id
    private int id;
    private long nit;
    private String direccion;
    private String nombre_contacto;
    private String telefono_contacto;
    private List<Integer> id_productos;

    public Proveedor(int id, long nit, String direccion, String nombre_contacto, String telefono_contacto,
            List<Integer> id_productos) {
        this.id = id;
        this.nit = nit;
        this.direccion = direccion;
        this.nombre_contacto = nombre_contacto;
        this.telefono_contacto = telefono_contacto;
        this.id_productos = id_productos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNIT() {
        return nit;
    }

    public void setNIT(long nIT) {
        nit = nIT;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

    public String getTelefono_contacto() {
        return telefono_contacto;
    }

    public void setTelefono_contacto(String telefono_contacto) {
        this.telefono_contacto = telefono_contacto;
    }

    public List<Integer> getId_productos() {
        return id_productos;
    }

    public void setId_productos(List<Integer> id_productos) {
        this.id_productos = id_productos;
    }

}
