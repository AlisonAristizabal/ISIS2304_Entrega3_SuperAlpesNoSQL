package uniandes.edu.co.proyecto.modelo;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "orden_de_compra")
@ToString
public class OrdenDeCompra {
    @Id
    private int id;
    private Date fecha_esperada_entrega;
    private String estado;
    private int id_sucursal;
    private int id_proveedor;
    private List<ProductoOrdenCompra> productosOrdenCompra;
}
