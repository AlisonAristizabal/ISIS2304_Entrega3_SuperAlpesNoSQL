package uniandes.edu.co.proyecto.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.modelo.Proveedor;

public interface ProveedorRepository extends MongoRepository<Proveedor,Integer>{

    // Consultar todos los proveedores
    @Query(value = "{}")
    List<Proveedor> buscarTodosLosProveedores();

    // Consultar proveedor por su ID
    @Query("{_id: ?0}")
    List<Proveedor> buscarPorId(int id);

    // Crear una nueva Proveedor
    @Query("{ $insert: { _id: ?0, nombre: ?1, telefono: ?2, direccion: ?3, ciudad: ?4} }")
    void insertarProveedor(int id, String nombre, String telefono, String direccion, Ciudad ciudad);

    // Actualizar un bar por su ID
    @Query("{ _id: ?0 }")
    @Update("{ $set: { nombre: ?1, ciudad: ?2, presupuesto: ?3, cant_sedes: ?4, oferta_bebidas: ?5 }}")
    void actualizarProveedor(int id, String nombre, String ciudad, String presupuesto, int cant_sedes, List<Bebida> oferta_bebidas);
}
