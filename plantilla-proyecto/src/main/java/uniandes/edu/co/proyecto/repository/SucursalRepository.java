package uniandes.edu.co.proyecto.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface SucursalRepository extends MongoRepository<Sucursal, String> {

    // Consultar todos las sucursales
    @Query(value = "{}")
    List<Sucursal> buscarTodasLasSucursales();

    // Consultar sucursal por su ID
    @Query("{_id: ?0}")
    List<Sucursal> buscarPorId(int id);

    /// Crear sucursal
    default void insertarSucursal(Sucursal sucursal) {
        save(sucursal);
    }
}
