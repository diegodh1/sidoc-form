package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.repository.JpaNegotiatedInvoiceEntity;
import co.integrapps.services.adapters.persistence.repository.JpaNegotiatedInvoiceRepository;
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

    @Override
    public List<JpaNegotiatedInvoiceEntity> getAllByHashCode(String codehash) {
        return negotiatedInvoiceRepository.findAllByCodehash(codehash);
    }
}
