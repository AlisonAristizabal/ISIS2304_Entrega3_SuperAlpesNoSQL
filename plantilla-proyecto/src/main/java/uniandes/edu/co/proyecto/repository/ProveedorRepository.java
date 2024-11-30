package uniandes.edu.co.proyecto.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.Proveedor;

public interface ProveedorRepository extends MongoRepository<Proveedor,Integer>{

    // Consultar todos los proveedores
    @Query(value = "{}")
    List<Proveedor> buscarTodosLosProveedores();

    // Consultar proveedor por su ID
    @Query("{_id: ?0}")
    List<Proveedor> buscarPorId(int id);

    // Crear un nuevo Proveedor
    @Query("{ $insert: { _id: ?0, nit: ?1, direccion: ?2, nombre_contacto: ?3, telefono_contacto: ?4, id_productos: ?5} }")
    void insertarProveedor(int id, long nit, String direccion, String nombre_contacto, String telefono_contacto, List<Integer> id_productos);

    // Actualizar un bar por su ID
    @Query("{ _id: ?0 }")
    @Update("{ $set: { nit: ?1, direccion: ?2, nombre_contacto: ?3, telefono_contacto: ?4, id_productos: ?5 }}")
    void actualizarProveedor(int id, long nit, String direccion, String nombre_contacto, String telefono_contacto, List<Integer> id_productos);
}
