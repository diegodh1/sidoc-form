package co.integrapps.services.adapters.persistence.repository;

import co.integrapps.services.adapters.persistence.repository.JpaNegotiatedInvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaUserOmnilatamRepository extends JpaRepository<JpaUserOmnilatam,String> {
    JpaUserOmnilatam getByIsActiveAndUsernameAndPasswrd(Boolean isActive, String username, String password);
    List<JpaUserOmnilatam> findAllByIsActive(Boolean isActive);
}
