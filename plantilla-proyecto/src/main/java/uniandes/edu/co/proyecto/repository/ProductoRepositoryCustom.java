package uniandes.edu.co.proyecto.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.bson.Document;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    public ProductoRepositoryCustom(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Document> filtrarProductos(Integer precioMin, Integer precioMax, String fechaVencimiento, String idCategoria) {
        List<Document> pipeline = new ArrayList<>();

        // Filtro por rango de precios
        if (precioMin != null && precioMax != null) {
            pipeline.add(new Document("$match", new Document("precio_unidad", new Document("$gte", precioMin).append("$lte", precioMax))));
        }

        // Filtro por fecha de vencimiento
        if (fechaVencimiento != null) {
            pipeline.add(new Document("$match", new Document("fecha_expiracion", new Document("$gte", fechaVencimiento))));
        }

        // Filtro por categoría
        if (idCategoria != null) {
            pipeline.add(new Document("$match", new Document("id_categoria", idCategoria)));
        }

        // Proyección final (opcional: para personalizar la salida)
        pipeline.add(new Document("$project", new Document("nombre", 1)
            .append("precio_unidad", 1)
            .append("fecha_expiracion", 1)
            .append("id_categoria", 1)));

        // Ejecutar la consulta
        return mongoTemplate.getCollection("producto").aggregate(pipeline).into(new ArrayList<>());
    }
}


