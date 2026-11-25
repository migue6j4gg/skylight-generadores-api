
package com.skylight.generadores.controller;

import com.skylight.generadores.model.GrupoElectrogeno;
import com.skylight.generadores.service.GrupoElectrogenoService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/grupos-electrogenos")
public class GrupoElectrogenoController {

    private final GrupoElectrogenoService service;

    public GrupoElectrogenoController(GrupoElectrogenoService service) {
        this.service = service;
    }

    // READ: listar todos
    @GetMapping
    public List<GrupoElectrogeno> listar() {
        return service.listar();
    }

    // READ: buscar por ID
    @GetMapping("/{id}")
    public GrupoElectrogeno buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    // CREATE: registrar
    @PostMapping
    public ResponseEntity<GrupoElectrogeno> registrar(
            @Valid @RequestBody GrupoElectrogeno grupo) {

        return ResponseEntity.status(201).body(service.registrar(grupo));
    }

    // UPDATE: actualizar
    @PutMapping("/{id}")
    public GrupoElectrogeno actualizar(
            @PathVariable Long id,
            @Valid @RequestBody GrupoElectrogeno grupo) {

        return service.actualizar(id, grupo);
    }

    // DELETE: eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
