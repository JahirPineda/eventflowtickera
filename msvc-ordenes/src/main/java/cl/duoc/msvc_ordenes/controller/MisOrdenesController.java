package cl.duoc.msvc_ordenes.controller;

import cl.duoc.msvc_ordenes.dto.MisOrdenesDTO;
import cl.duoc.msvc_ordenes.service.MisOrdenesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class MisOrdenesController {

    @Autowired
    private MisOrdenesService service;

    @GetMapping
    public ResponseEntity<List<MisOrdenesDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MisOrdenesDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<MisOrdenesDTO> create(@Valid @RequestBody MisOrdenesDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MisOrdenesDTO> update(@PathVariable int id, @Valid @RequestBody MisOrdenesDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("Orden eliminada");
    }

    // Reportes
    @GetMapping("/reporte/cliente/{clienteId}")
    public ResponseEntity<List<MisOrdenesDTO>> getByCliente(@PathVariable int clienteId) {
        return ResponseEntity.ok(service.getByCliente(clienteId));
    }

    @GetMapping("/reporte/evento/{eventoId}")
    public ResponseEntity<List<MisOrdenesDTO>> getByEvento(@PathVariable int eventoId) {
        return ResponseEntity.ok(service.getByEvento(eventoId));
    }

    @GetMapping("/reporte/estado/{estado}")
    public ResponseEntity<List<MisOrdenesDTO>> getByEstado(@PathVariable String estado) {
        return ResponseEntity.ok(service.getByEstado(estado));
    }

    @GetMapping("/reporte/metodo/{metodoPago}")
    public ResponseEntity<List<MisOrdenesDTO>> getByMetodoPago(@PathVariable String metodoPago) {
        return ResponseEntity.ok(service.getByMetodoPago(metodoPago));
    }

    @GetMapping("/reporte/total/{total}")
    public ResponseEntity<List<MisOrdenesDTO>> getByTotalMinimo(@PathVariable double total) {
        return ResponseEntity.ok(service.getByTotalMinimo(total));
    }
}