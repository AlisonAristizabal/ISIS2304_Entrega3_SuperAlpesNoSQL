package uniandes.edu.co.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Categoria;
import uniandes.edu.co.proyecto.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Crear una nueva categoría
    @PostMapping("/new/save")
    public ResponseEntity<String> crearCategoria(@RequestBody Categoria categoria) {
        try {
            categoriaRepository.save(categoria);
            return new ResponseEntity<>("Categoría creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la categoría: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener todas las categorías
    @GetMapping
    public ResponseEntity<List<Categoria>> obtenerTodasLasCategorias() {
        try {
            List<Categoria> categorias = categoriaRepository.findAll();
            return ResponseEntity.ok(categorias);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Obtener una categoría por ID o nombre
    @GetMapping("/buscar")
    public ResponseEntity<?> obtenerCategoria(
            @RequestParam(value = "_id", required = false) String _id,
            @RequestParam(value = "nombre", required = false) String nombre) {
        try {
            if (_id != null) {
                return categoriaRepository.findById(_id)
                        .map(ResponseEntity::ok)
                        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
            } else if (nombre != null) {
                List<Categoria> categorias = categoriaRepository.buscarPorNombre(nombre);
                if (!categorias.isEmpty()) {
                    return ResponseEntity.ok(categorias);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>("Debe proporcionar un ID o nombre", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
