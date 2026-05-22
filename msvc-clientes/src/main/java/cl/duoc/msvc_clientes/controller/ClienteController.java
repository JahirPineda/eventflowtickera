package cl.duoc.msvc_clientes.controller;

import cl.duoc.msvc_clientes.dto.ClienteDTO;
import cl.duoc.msvc_clientes.exception.ResourceNotFoundException;
import cl.duoc.msvc_clientes.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable int id, @Valid @RequestBody ClienteDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("Cliente eliminado");
    }

    // Reportes
    @GetMapping("/reporte/email/{email}")
    public ResponseEntity<ClienteDTO> getByEmail(@PathVariable String email) {
        return service.getByEmail(email)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con email: " + email));
    }

    @GetMapping("/reporte/rut/{rut}")
    public ResponseEntity<ClienteDTO> getByRut(@PathVariable String rut) {
        return service.getByRut(rut)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con rut: " + rut));
    }

    @GetMapping("/reporte/tipo/{tipoCliente}")
    public ResponseEntity<List<ClienteDTO>> getByTipo(@PathVariable String tipoCliente) {
        return ResponseEntity.ok(service.getByTipo(tipoCliente));
    }

    @GetMapping("/reporte/activos")
    public ResponseEntity<List<ClienteDTO>> getActivos() {
        return ResponseEntity.ok(service.getActivos());
    }

    @GetMapping("/reporte/ciudad/{ciudad}")
    public ResponseEntity<List<ClienteDTO>> getByCiudad(@PathVariable String ciudad) {
        return ResponseEntity.ok(service.getByCiudad(ciudad));
    }
}