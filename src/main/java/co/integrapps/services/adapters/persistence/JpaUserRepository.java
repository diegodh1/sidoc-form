package co.integrapps.services.adapters.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface JpaUserRepository extends JpaRepository<JpaUser,Integer> {
    Optional<JpaUser> findByStrusuarioEqualsAndStrpasswordEquals(@NonNull String strusuario, @NonNull String strpassword);

}
