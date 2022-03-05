package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.JpaNegotiatedInvoiceEntity;
import co.integrapps.services.adapters.persistence.JpaNegotiatedInvoiceRepository;
import co.integrapps.services.application.port.in.GetNegotiatedInvoiceUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetNegotiatedInvoiceService implements GetNegotiatedInvoiceUseCase {
    private final JpaNegotiatedInvoiceRepository negotiatedInvoiceRepository;

    @Override
    public List<JpaNegotiatedInvoiceEntity> getAllNegotiatedInvoice() {
        return negotiatedInvoiceRepository.findAll();
    }
}
