package co.integrapps.services.adapters.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaEptDocRepository extends JpaRepository<JpaEptDoc,Integer> {
    List<JpaEptDoc> findAllByBarcodehEquals(@NonNull String barcode);

}
