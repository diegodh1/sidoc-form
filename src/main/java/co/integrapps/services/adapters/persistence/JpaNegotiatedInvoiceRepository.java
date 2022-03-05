package co.integrapps.services.adapters.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaNegotiatedInvoiceRepository extends JpaRepository<JpaNegotiatedInvoiceEntity,Integer> {
}
