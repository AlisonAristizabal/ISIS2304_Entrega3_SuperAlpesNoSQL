package uniandes.edu.co.proyecto.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.Bodega;

public interface BodegaRepository extends MongoRepository<Bodega,Integer>{

    // Consultar todos las bodegas 
    @Query(value = "{}")
    List<Bodega> buscarTodasLasBodegas();

    // Consultar bodega por su ID
    @Query("{_id: ?0}")
    List<Bodega> buscarPorId(int id);

    //Crear Bodega
    default void insertarBodega(Bodega bodega){
        save(bodega);
    }

    // Eliminar una bodega por su ID
    @Query(value = "{_id: ?0}", delete = true)
    void eliminarBodegaPorId(int id);
}
