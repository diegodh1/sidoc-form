package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.persistence.InvoiceJpaEntity;

import java.util.List;

public interface GetInvoicesToNegotiateUseCase {
    List<InvoiceJpaEntity> getAllInvoices();
}
