package co.integrapps.services.adapters.persistence.repository;

import co.integrapps.services.adapters.persistence.repository.JpaInvoiceToNegotiateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaInvoiceToNegotiateRepository extends JpaRepository<JpaInvoiceToNegotiateEntity,String> {
}
