package co.integrapps.services.adapters.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaModalidadEntregaRepository extends JpaRepository<JpaModalidadEntrega,String> {
    List<JpaModalidadEntrega> findAllByActivoTrue();
}
