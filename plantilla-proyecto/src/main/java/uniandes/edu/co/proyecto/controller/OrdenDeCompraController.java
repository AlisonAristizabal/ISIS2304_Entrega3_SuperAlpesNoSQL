package uniandes.edu.co.proyecto.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.OrdenDeCompra;
import uniandes.edu.co.proyecto.repository.OrdenDeCompraRepository;

@RestController
@RequestMapping("/ordenes_de_compra")
public class OrdenDeCompraController {
    @Autowired
    private OrdenDeCompraRepository ordenDeCompraRepository;

    // Obtener todas las ordenes de compra
    @GetMapping("")
    public ResponseEntity<List<OrdenDeCompra>> obtenerTodasOrdenesDeCompra() {
        System.out.println("Entro a funcion");
        try {
            List<OrdenDeCompra> ordenes = ordenDeCompraRepository.buscarTodasLasOrdenesDeCompra();
            System.out.println("Selecciono");
            return ResponseEntity.ok(ordenes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Obtener una orden de compra por id
    @GetMapping("/{_id}")
    public ResponseEntity<List<OrdenDeCompra>> obtenerOrdenDeCompraPorId(@PathVariable("_id") ObjectId id) {
        try {
            List<OrdenDeCompra> ordenes = ordenDeCompraRepository.buscarPorId(id);
            if (ordenes != null && !ordenes.isEmpty()) {
                for (OrdenDeCompra orden : ordenes) {
                    orden.setId_proveedor(new ObjectId(String.valueOf(orden.getId_proveedor())));
                    orden.setId_sucursal(new ObjectId(String.valueOf(orden.getId_sucursal())));
                }
                return ResponseEntity.ok(ordenes);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Crear una nueva orden de compra
    @PostMapping("/new/save")
    public ResponseEntity<String> crearBar(@RequestBody OrdenDeCompra orden) {
        try {
            ordenDeCompraRepository.save(orden);
            return new ResponseEntity<>("Bar creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            ;
            return new ResponseEntity<>("Error al crear el bar: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
