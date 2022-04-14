package co.integrapps.services.adapters.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaUsuarioRepository extends JpaRepository<JpaUsuario, String> {
    JpaUsuario findByUserIdAndPassword(String userId, String password);
    List<JpaUsuario> findAllByNameContains(String name);
}
