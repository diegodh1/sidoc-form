package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.persistence.repository.JpaNegotiatedInvoiceEntity;

import java.util.List;

public interface GetNegotiatedInvoiceUseCase {
    List<JpaNegotiatedInvoiceEntity> getAllNegotiatedInvoice();
    List<JpaNegotiatedInvoiceEntity> getAllByHashCode(String codehash);
}
