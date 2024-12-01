package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "proveedor")
@ToString
public class Proveedor {
    @Id
    private String _id;
    private long nit;
    private String direccion;
    private String nombre_contacto;
    private String telefono_contacto;
    private List<String> id_productos;

    public Proveedor(String _id, long nit, String direccion, String nombre_contacto, String telefono_contacto,
            List<String> id_productos) {
        this._id = _id;
        this.nit = nit;
        this.direccion = direccion;
        this.nombre_contacto = nombre_contacto;
        this.telefono_contacto = telefono_contacto;
        this.id_productos = id_productos;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
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

    public List<String> getId_productos() {
        return id_productos;
    }

    public void setId_productos(List<String> id_productos) {
        this.id_productos = id_productos;
    }

}
