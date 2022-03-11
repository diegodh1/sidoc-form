package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.repository.JpaInvoiceToNegotiateEntity;
import co.integrapps.services.adapters.persistence.repository.JpaInvoiceToNegotiateRepository;
import co.integrapps.services.application.port.in.GetInvoicesToNegotiateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
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
