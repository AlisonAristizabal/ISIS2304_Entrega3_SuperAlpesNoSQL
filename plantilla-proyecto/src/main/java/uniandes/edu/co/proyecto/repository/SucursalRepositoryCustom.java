package uniandes.edu.co.proyecto.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.bson.Document;
import org.bson.types.ObjectId;

@Repository
public class SucursalRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    public SucursalRepositoryCustom(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Document> obtenerInventarioPorSucursal(ObjectId idSucursal) {
        List<Document> pipeline = List.of(
                // Filtrar la sucursal específica
                new Document("$match", new Document("_id", idSucursal)),

                // Hacer lookup con la colección "bodega"
                new Document("$lookup", new Document()
                        .append("from", "bodega")
                        .append("localField", "_id") // _id de la sucursal
                        .append("foreignField", "id_sucursal") // id_sucursal en bodega
                        .append("as", "bodegas")),

                // Descomponer la lista de bodegas
                new Document("$unwind", "$bodegas"),

                // Descomponer la lista de productos en bodega (productos_en_bodega está
                // embebido)
                new Document("$unwind", "$bodegas.productos_en_bodega"),

                // Hacer lookup con la colección "producto" para obtener más información sobre
                // los productos
                new Document("$lookup", new Document()
                        .append("from", "producto")
                        .append("localField", "bodegas.productos_en_bodega.id_producto") // id_producto en
                                                                                         // productos_en_bodega
                        .append("foreignField", "_id") // _id en producto
                        .append("as", "productoInfo")),

                // Descomponer la lista de productos
                new Document("$unwind", "$productoInfo"),

                // Agrupar la información por bodega y producto
                new Document("$group", new Document()
                        .append("_id", "$bodegas.nombre") // Agrupar por el nombre de la bodega
                        .append("productos", new Document("$push", new Document()
                                .append("nombre", "$productoInfo.nombre")
                                .append("cantidad_actual", "$bodegas.productos_en_bodega.cantidad")
                                .append("cantidad_minima", "$bodegas.productos_en_bodega.minimoReorden")
                                .append("costo_promedio", "$bodegas.productos_en_bodega.costoPromedio")))));

        // Ejecutar la consulta y devolver el resultado
        return mongoTemplate.getCollection("sucursal").aggregate(pipeline).into(new ArrayList<>());
    }
}
