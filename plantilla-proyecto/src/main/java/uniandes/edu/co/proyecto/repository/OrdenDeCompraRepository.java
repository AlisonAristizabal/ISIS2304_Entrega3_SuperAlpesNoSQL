package uniandes.edu.co.proyecto.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.OrdenDeCompra;

public interface OrdenDeCompraRepository extends MongoRepository<OrdenDeCompra, String> {

    // Consultar todas las ordenes de compra
    @Query(value = "{}")
    List<OrdenDeCompra> buscarTodasLasOrdenesDeCompra();

    // Consultar orden de compra por id
    @Query("{_id: ?0}")
    List<OrdenDeCompra> buscarPorId(ObjectId id);

    default void insertarOrdenDeCompra(OrdenDeCompra ordenDeCompra) {
        save(ordenDeCompra);
    }

}
