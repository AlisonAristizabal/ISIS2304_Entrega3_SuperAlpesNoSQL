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

import uniandes.edu.co.proyecto.modelo.Sucursal;
import uniandes.edu.co.proyecto.repository.SucursalRepository;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private SucursalRepository sucursalRepository;

    // Crear una nueva sucursal
    @PostMapping("/new/save")
    public ResponseEntity<String> crearSucursal(@RequestBody Sucursal sucursal) {
        try {
            sucursalRepository.save(sucursal);
            return new ResponseEntity<>("Sucursal creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {;
            return new ResponseEntity<>("Error al crear la sucursal: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener todos las sucursales
    @GetMapping("")
    public ResponseEntity<List<Sucursal>> obtenerTodasLasSucursales() {
        try {
            List<Sucursal> sucursales = sucursalRepository.buscarTodasLasSucursales();
            return ResponseEntity.ok(sucursales);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Obtener un bar por ID
    @GetMapping("/{id}")
    public ResponseEntity<List<Sucursal>> obtenerBarPorId(@PathVariable("id") int id) {
        try {
            List<Sucursal> sucursales = sucursalRepository.buscarPorId(id);
            if (sucursales != null && !sucursales.isEmpty()) {
                return ResponseEntity.ok(sucursales);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
