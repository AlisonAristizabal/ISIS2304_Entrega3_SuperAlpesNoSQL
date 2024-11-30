package uniandes.edu.co.proyecto.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.ProductosEnBodega;

public interface BodegaRepository extends MongoRepository<Bodega,Integer>{

    // Consultar todos las bodegas 
    @Query(value = "{}")
    List<Bodega> buscarTodasLasBodegas();

    // Consultar bodega por su ID
    @Query("{_id: ?0}")
    List<Bodega> buscarPorId(int id);

    // Crear una nueva bodega
    @Query("{ $insert: { _id: ?0, nombre: ?1, tamanio: ?2, id_sucursal: ?3, productos_en_bodega: ?4} }")
    void insertarBodega(int id, String nombre, double tamanio, int id_sucursal, List<ProductosEnBodega> productos_en_bodega);

    // Eliminar una bodega por su ID
    @Query(value = "{_id: ?0}", delete = true)
    void eliminarBodegaPorId(int id);
}
