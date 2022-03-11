package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.persistence.repository.JpaInvoiceToNegotiateEntity;

import java.util.List;

public interface GetInvoicesToNegotiateUseCase {
    List<JpaInvoiceToNegotiateEntity> getAllInvoices();
}
