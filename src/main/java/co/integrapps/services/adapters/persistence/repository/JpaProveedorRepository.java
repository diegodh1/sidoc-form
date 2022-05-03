package co.integrapps.services.adapters.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaProveedorRepository extends JpaRepository<JpaProveedor, String> {
    List<JpaProveedor> findAllByActivoTrue();
}
