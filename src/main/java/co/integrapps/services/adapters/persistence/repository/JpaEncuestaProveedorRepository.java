package co.integrapps.services.adapters.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaEncuestaProveedorRepository extends JpaRepository<JpaEncuestaProveedor,Integer> {
    List<JpaEncuestaProveedor> findAllByEncuesta(JpaEncuestaSatisfaccion encuestaSatisfaccion);
    void deleteAllByEncuestaEncuestaId(Integer encuestaId);
}
