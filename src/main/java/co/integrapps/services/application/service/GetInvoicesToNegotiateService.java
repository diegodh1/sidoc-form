package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.InvoiceJpaEntity;
import co.integrapps.services.adapters.persistence.JpaInvoicesRepository;
import co.integrapps.services.application.port.in.GetInvoicesToNegotiateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetInvoicesToNegotiateService implements GetInvoicesToNegotiateUseCase {
    @Autowired
    private JpaInvoicesRepository invoicesRepository;

    @Override
    public List<InvoiceJpaEntity> getAllInvoices() {
        return invoicesRepository.findAll();
    }
}
