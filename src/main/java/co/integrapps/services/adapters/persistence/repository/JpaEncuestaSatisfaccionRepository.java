package co.integrapps.services.adapters.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaEncuestaSatisfaccionRepository extends JpaRepository<JpaEncuestaSatisfaccion,Integer> {
    @Query(value = "SELECT * FROM encuesta_satisfaccion u WHERE u.nombre like %:name% order by u.encuesta_id desc limit 1", nativeQuery = true)
    List<JpaEncuestaSatisfaccion> filterByName(String name);

    void deleteAllByEncuestaId(Integer encuestaId);
}
