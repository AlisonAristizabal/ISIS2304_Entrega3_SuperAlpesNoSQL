package uniandes.edu.co.proyecto.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface SucursalRepository extends MongoRepository<Sucursal,Integer>{

    // Consultar todos las sucursales 
    @Query(value = "{}")
    List<Sucursal> buscarTodasLasSucursales();

    // Consultar sucursal por su ID
    @Query("{_id: ?0}")
    List<Sucursal> buscarPorId(int id);

    // Crear una nueva sucursal
    @Query("{ $insert: { _id: ?0, nombre: ?1, telefono: ?2, direccion: ?3, ciudad: ?4} }")
    void insertarSucursal(int id, String nombre, String telefono, String direccion, Ciudad ciudad);
}
