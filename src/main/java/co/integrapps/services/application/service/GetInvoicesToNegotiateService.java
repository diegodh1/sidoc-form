package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.JpaInvoiceToNegotiateEntity;
import co.integrapps.services.adapters.persistence.JpaInvoiceToNegotiateRepository;
import co.integrapps.services.application.port.in.GetInvoicesToNegotiateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetInvoicesToNegotiateService implements GetInvoicesToNegotiateUseCase {
    @Autowired
    private JpaInvoiceToNegotiateRepository invoicesRepository;

    @Override

    public List<JpaInvoiceToNegotiateEntity> getAllInvoices() {
        return invoicesRepository.findAll();
    }
}
