package uniandes.edu.co.proyecto.repository;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.Producto;

public interface ProductoRepository extends MongoRepository<Producto, Integer>{

    //Crear producto
    default void insertarProducto(Producto producto){
        save(producto);
    }

    // Consultar producto por su ID
    @Aggregation(pipeline = {
    "{ $lookup: { from: 'categoria', localField: 'codigo_categoria', foreignField: '_id', as: 'categoriaInfo' } }",
    "{ $match: { _id: ?0 } }"})
    Producto findProductoConCategoriaById(int id);

    // Consultar producto por su nombre
    @Aggregation(pipeline = {
        "{ $lookup: { from: 'categoria', localField: 'codigo_categoria', foreignField: '_id', as: 'categoriaInfo' } }",
        "{ $match: { nombre: ?0 } }"
    })
    Producto findProductoConCategoriaByNombre(String nombre);
    
    @Query( "{ '_id': ?0 }")
    @Update ("{ $set: { 'nombre': ?1, 'costo_bodega': ?2, 'precio_unidad': ?3 } }")
    void actualizarCamposProducto(int id, String nombre, int costoBodega, int precioUnidad);

}
