
package com.skylight.generadores.service;

import com.skylight.generadores.model.GrupoElectrogeno;
import com.skylight.generadores.repository.GrupoElectrogenoRepository;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GrupoElectrogenoService {

    private final GrupoElectrogenoRepository repository;

    public GrupoElectrogenoService(GrupoElectrogenoRepository repository) {
        this.repository = repository;
    }

    // READ: listar todos los grupos
    public List<GrupoElectrogeno> listar() {
        return repository.findAll();
    }

    // READ: buscar un grupo por ID
    public GrupoElectrogeno buscar(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Grupo electrógeno no encontrado"));
    }

    // CREATE: registrar un grupo
    public GrupoElectrogeno registrar(GrupoElectrogeno grupo) {
        grupo.setId(null);
        return repository.save(grupo);
    }

    // UPDATE: actualizar un grupo
    public GrupoElectrogeno actualizar(Long id, GrupoElectrogeno datos) {
        GrupoElectrogeno grupo = buscar(id);

        grupo.setModelo(datos.getModelo());
        grupo.setMarca(datos.getMarca());
        grupo.setPotenciaKva(datos.getPotenciaKva());
        grupo.setEstado(datos.getEstado());

        return repository.save(grupo);
    }

    // DELETE: eliminar un grupo
    public void eliminar(Long id) {
        GrupoElectrogeno grupo = buscar(id);
        repository.delete(grupo);
    }
}
