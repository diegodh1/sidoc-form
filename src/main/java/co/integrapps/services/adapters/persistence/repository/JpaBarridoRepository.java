package co.integrapps.services.adapters.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaBarridoRepository extends JpaRepository<JpaBarrido, String> {
    List<JpaBarrido> findAllByActivoTrue();
}
