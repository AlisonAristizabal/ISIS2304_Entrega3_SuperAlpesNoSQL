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
    private String _id;
    private int id;
    private Date fecha_esperada_entrega;
    private String estado;
    private int id_sucursal;
    private int id_proveedor;
    private List<ProductoOrdenCompra> productos_orden_compra;

    public OrdenDeCompra() {
    }

    public OrdenDeCompra(int id, Date fecha_esperada_entrega, String estado, int id_sucursal, int id_proveedor,
            List<ProductoOrdenCompra> productosOrdenCompra) {
        this.id = id;
        this.fecha_esperada_entrega = fecha_esperada_entrega;
        this.estado = estado;
        this.id_sucursal = id_sucursal;
        this.id_proveedor = id_proveedor;
        this.productos_orden_compra = productosOrdenCompra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public List<ProductoOrdenCompra> getProductosOrdenCompra() {
        return productos_orden_compra;
    }

    public void setProductosOrdenCompra(List<ProductoOrdenCompra> productosOrdenCompra) {
        this.productos_orden_compra = productosOrdenCompra;
    }

}
