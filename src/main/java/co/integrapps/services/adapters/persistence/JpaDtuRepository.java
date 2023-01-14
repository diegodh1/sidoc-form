package co.integrapps.services.adapters.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaDtuRepository extends JpaRepository<JpaDtu,Integer> {
}
