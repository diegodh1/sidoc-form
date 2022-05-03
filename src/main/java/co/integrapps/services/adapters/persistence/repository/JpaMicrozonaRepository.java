package co.integrapps.services.adapters.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaMicrozonaRepository extends JpaRepository<JpaMicrozona, String> {
    List<JpaMicrozona> findAllByActivoTrue();
}
