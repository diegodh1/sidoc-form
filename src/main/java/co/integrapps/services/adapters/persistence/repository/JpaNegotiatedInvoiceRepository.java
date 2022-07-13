package co.integrapps.services.adapters.persistence.repository;

import co.integrapps.services.adapters.persistence.repository.JpaNegotiatedInvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaNegotiatedInvoiceRepository extends JpaRepository<JpaNegotiatedInvoiceEntity,Integer> {
    List<JpaNegotiatedInvoiceEntity> findAllByCodehash(String codehash);
}
