package uniandes.edu.co.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.repository.BodegaRepository;

@RestController
@RequestMapping("/bodegas")
public class BodegaController {

    @Autowired
    private BodegaRepository bodegaRepository;

    // Crear una nueva bodega
    @PostMapping("/new/save")
    public ResponseEntity<String> crearBodega(@RequestBody Bodega bodega) {
        try {
            bodegaRepository.save(bodega);
            return new ResponseEntity<>("Bodega creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {;
            return new ResponseEntity<>("Error al crear la bodega: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener todos las sucursales
    @GetMapping("")
    public ResponseEntity<List<Bodega>> obtenerTodasLasBodegas() {
        try {
            List<Bodega> bodegas = bodegaRepository.buscarTodasLasBodegas();
            return ResponseEntity.ok(bodegas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Obtener un bar por ID
    @GetMapping("/{id}")
    public ResponseEntity<List<Bodega>> obtenerBarPorId(@PathVariable("id") int id) {
        try {
            List<Bodega> bodegas = bodegaRepository.buscarPorId(id);
            if (bodegas != null && !bodegas.isEmpty()) {
                return ResponseEntity.ok(bodegas);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Eliminar una bodega por su ID
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> eliminarBodega(@PathVariable("id") int id) {
        try {
            bodegaRepository.eliminarBodegaPorId(id);
            return new ResponseEntity<>("Bodega eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la bodega: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
