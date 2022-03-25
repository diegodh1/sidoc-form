package co.integrapps.services.adapters.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaEncuestaSatisfaccionRepository extends JpaRepository<JpaEncuestaSatisfaccion,Integer> {
    @Query("SELECT u FROM encuesta_satisfaccion u WHERE u.nombre like %?1%")
    List<JpaEncuestaSatisfaccion> filterByName(String name);
}
