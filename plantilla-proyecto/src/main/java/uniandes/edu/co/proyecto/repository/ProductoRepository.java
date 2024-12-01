package uniandes.edu.co.proyecto.repository;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String> {

    // Crear producto
    default void insertarProducto(Producto producto) {
        save(producto);
    }

    @Aggregation(pipeline = {
            "{ $lookup: { from: 'categoria', localField: 'id_categoria', foreignField: '_id', as: 'categoriaInfo' } }",
            "{ $match: { _id: ?0 } }",
            "{ $project: { id: 1, nombre: 1, costo_bodega: 1, precio_unidad: 1, categoriaInfo: 1 } }"
    })
    Producto findProductoConCategoriaById(int id);

    @Aggregation(pipeline = {
            "{ $lookup: { from: 'categoria', localField: 'id_categoria', foreignField: '_id', as: 'categoriaInfo' } }",
            "{ $match: { nombre: ?0 } }",
            "{ $project: { id: 1, nombre: 1, costo_bodega: 1, precio_unidad: 1, categoriaInfo: 1 } }"
    })
    Producto findProductoConCategoriaByNombre(String nombre);

    @Query("{ '_id': ?0 }")
    @Update("{ $set: { 'nombre': ?1, 'costo_bodega': ?2, 'precio_unidad': ?3 } }")
    void actualizarCamposProducto(String id, String nombre, int costoBodega, int precioUnidad);

}
