package co.integrapps.services.adapters.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaInvoicesRepository extends JpaRepository<InvoiceJpaEntity,String> {
}
