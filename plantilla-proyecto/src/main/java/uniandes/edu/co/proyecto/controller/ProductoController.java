package uniandes.edu.co.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.bson.Document;

import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.repository.ProductoRepository;
import uniandes.edu.co.proyecto.repository.ProductoRepositoryCustom;

@RestController
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // Crear un nuevo producto
    @PostMapping
    public ResponseEntity<?> crearProducto(@RequestBody Producto producto) {
        try {
            productoRepository.insertarProducto(producto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Producto creado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear el producto: " + e.getMessage());
        }
    }

    // Consultar un producto por su ID (incluyendo la categoría)
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerProductoConCategoriaPorId(@PathVariable int id) {
        try {
            Producto producto = productoRepository.findProductoConCategoriaById(id);
            if (producto != null) {
                return ResponseEntity.ok(producto);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado con ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar el producto: " + e.getMessage());
        }
    }

    // Consultar un producto por su nombre (incluyendo la categoría)
    @GetMapping("/buscarPorNombre/{nombre}")
    public ResponseEntity<?> obtenerProductoConCategoriaPorNombre(@PathVariable String nombre) {
        try {
            Producto producto = productoRepository.findProductoConCategoriaByNombre(nombre);
            if (producto != null) {
                return ResponseEntity.ok(producto);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado con nombre: " + nombre);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar el producto: " + e.getMessage());
        }
    }

    // Actualizar campos específicos de un producto
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCamposProducto(
            @PathVariable String _id,
            @RequestBody Producto productoActualizado) {
        try {
            Optional<Producto> productoExistente = productoRepository.findById(_id);
            if (productoExistente.isPresent()) {
                productoRepository.actualizarCamposProducto(
                        _id,
                        productoActualizado.getNombre(),
                        productoActualizado.getCosto_bodega(),
                        productoActualizado.getPrecio_unidad());
                return ResponseEntity.ok("Producto actualizado exitosamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado con ID: " + _id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el producto: " + e.getMessage());
        }
    }

    private final ProductoRepositoryCustom productoRepositoryCustom;

    public ProductoController(ProductoRepositoryCustom productoRepositoryCustom) {
        this.productoRepositoryCustom = productoRepositoryCustom;
    }

    @GetMapping("/filtrar")
    public ResponseEntity<?> filtrarProductos(
            @RequestParam(required = false) Integer precioMin,
            @RequestParam(required = false) Integer precioMax,
            @RequestParam(required = false) String fechaVencimiento,
            @RequestParam(required = false) String idCategoria) {
        try {
            List<Document> productos = productoRepositoryCustom.filtrarProductos(precioMin, precioMax, fechaVencimiento, idCategoria);
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al filtrar productos: " + e.getMessage());
        }
    }
}
