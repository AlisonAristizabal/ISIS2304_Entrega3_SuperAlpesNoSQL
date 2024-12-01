package uniandes.edu.co.proyecto.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.Categoria;

public interface CategoriaRepository extends MongoRepository<Categoria, String> {

    // Consultar todas las categorías (puedes usar findAll() directamente)
    @Query(value = "{}")
    List<Categoria> buscarTodasLasCategorias();

    // Consultar categoría por nombre
    @Query("{ 'nombre': ?0 }")
    List<Categoria> buscarPorNombre(String nombre);
}
