package uniandes.edu.co.proyecto.modelo;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "orden_de_compra")
@ToString
public class OrdenDeCompra {
    @Id
    private String _id;
    private Date fecha_esperada_entrega;
    private String estado;
    private ObjectId id_sucursal;
    private ObjectId id_proveedor;
    private List<ProductoOrdenCompra> productos_orden_compra;

    public OrdenDeCompra(String _id, Date fecha_esperada_entrega, String estado, ObjectId id_sucursal,
            ObjectId id_proveedor, List<ProductoOrdenCompra> productos_orden_compra) {
        this._id = _id;
        this.fecha_esperada_entrega = fecha_esperada_entrega;
        this.estado = estado;
        this.id_sucursal = id_sucursal;
        this.id_proveedor = id_proveedor;
        this.productos_orden_compra = productos_orden_compra;
    }

    public OrdenDeCompra() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Date getFecha_esperada_entrega() {
        return fecha_esperada_entrega;
    }

    public void setFecha_esperada_entrega(Date fecha_esperada_entrega) {
        this.fecha_esperada_entrega = fecha_esperada_entrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ObjectId getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(ObjectId id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public ObjectId getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(ObjectId id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public List<ProductoOrdenCompra> getProductos_orden_compra() {
        return productos_orden_compra;
    }

    public void setProductos_orden_compra(List<ProductoOrdenCompra> productos_orden_compra) {
        this.productos_orden_compra = productos_orden_compra;
    }

}
