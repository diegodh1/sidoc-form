package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.persistence.JpaNegotiatedInvoiceEntity;
import co.integrapps.services.adapters.web.dto.ResponseNegotiateInvoiceDto;

import java.util.List;

public interface PostNegotiateInvoiceUseCase {
    ResponseNegotiateInvoiceDto execute(List<JpaNegotiatedInvoiceEntity> invoices);
}
