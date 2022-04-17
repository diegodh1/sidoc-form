package co.integrapps.services.adapters.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaMarcaProveedorRepository extends JpaRepository<JpaMarcaProveedor, String> {
    List<JpaMarcaProveedor> findAllByActivoTrue();
}
