package uniandes.edu.co.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Proveedor;
import uniandes.edu.co.proyecto.repository.ProveedorRepository;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Crear un nuevo proveedor
    @PostMapping("/new/save")
    public ResponseEntity<String> crearProveedor(@RequestBody Proveedor proveedor) {
        try {
            proveedorRepository.save(proveedor);
            return new ResponseEntity<>("Proveedor creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {;
            return new ResponseEntity<>("Error al crear el proveedor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener todos las sucursales
    @GetMapping("")
    public ResponseEntity<List<Proveedor>> obtenerTodosLosProveedores() {
        try {
            List<Proveedor> proveedores = proveedorRepository.buscarTodosLosProveedores();
            return ResponseEntity.ok(proveedores);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Obtener una sucursal por ID
    @GetMapping("/{id}")
    public ResponseEntity<List<Proveedor>> obtenerProveedorPorId(@PathVariable("id") int id) {
        try {
            List<Proveedor> proveedores = proveedorRepository.buscarPorId(id);
            if (proveedores != null && !proveedores.isEmpty()) {
                return ResponseEntity.ok(proveedores);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Actualizar un proveedor existente
    @PostMapping("/{id}/edit/save")
    public ResponseEntity<String> actualizarProveedor(@PathVariable("id") int id, @RequestBody Proveedor proveedor) {
        try {
            proveedorRepository.actualizarProveedor(
                id, 
                proveedor.getNIT(), 
                proveedor.getDireccion(), 
                proveedor.getNombre_contacto(), 
                proveedor.getTelefono_contacto(), 
                proveedor.getId_productos());
            
            return new ResponseEntity<>("Proveedor actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el bar: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
