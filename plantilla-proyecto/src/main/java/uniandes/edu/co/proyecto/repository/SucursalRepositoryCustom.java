package uniandes.edu.co.proyecto.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.bson.Document;

@Repository
public class SucursalRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    public SucursalRepositoryCustom(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Document> obtenerInventarioPorSucursal(String idSucursal) {
        List<Document> pipeline = List.of(
            // Filtrar la sucursal específica
            new Document("$match", new Document("_id", idSucursal)),
            // Hacer lookup con la colección "bodega"
            new Document("$lookup", new Document()
                .append("from", "bodega")
                .append("localField", "_id")
                .append("foreignField", "id_sucursal")
                .append("as", "bodegas")
            ),
            // Descomponer la lista de bodegas
            new Document("$unwind", "$bodegas"),
            // Hacer lookup con la colección "productos_en_bodega"
            new Document("$lookup", new Document()
                .append("from", "productos_en_bodega")
                .append("localField", "bodegas._id")
                .append("foreignField", "id_bodega")
                .append("as", "productosEnBodega")
            ),
            // Descomponer la lista de productos en bodega
            new Document("$unwind", "$productosEnBodega"),
            // Hacer lookup con la colección "producto"
            new Document("$lookup", new Document()
                .append("from", "producto")
                .append("localField", "productosEnBodega.id_producto")
                .append("foreignField", "_id")
                .append("as", "productoInfo")
            ),
            // Descomponer la lista de productos
            new Document("$unwind", "$productoInfo"),
            // Agrupar por bodega y listar productos
            new Document("$group", new Document()
                .append("_id", "$bodegas.nombre")
                .append("productos", new Document("$push", new Document()
                    .append("nombre", "$productoInfo.nombre")
                    .append("cantidad_actual", "$productosEnBodega.cantidad")
                    .append("cantidad_minima", "$productosEnBodega.cantidad_minima")
                    .append("costo_promedio", "$productosEnBodega.costo_promedio")
                ))
            )
        );

        // Ejecutar la consulta
        return mongoTemplate.getCollection("sucursal").aggregate(pipeline).into(new ArrayList<>());
    }
}

