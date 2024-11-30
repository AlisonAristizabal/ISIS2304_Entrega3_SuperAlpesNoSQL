package uniandes.edu.co.proyecto.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface SucursalRepository extends MongoRepository<Sucursal,Integer>{

    // Consultar todos las sucursales 
    @Query(value = "{}")
    List<Sucursal> buscarTodasLasSucursales();

    
}
