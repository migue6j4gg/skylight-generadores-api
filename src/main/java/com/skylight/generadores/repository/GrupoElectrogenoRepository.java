
package com.skylight.generadores.repository;

import com.skylight.generadores.model.GrupoElectrogeno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoElectrogenoRepository
        extends JpaRepository<GrupoElectrogeno, Long> {
}
