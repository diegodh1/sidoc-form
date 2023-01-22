package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.JpaEptDoc;
import co.integrapps.services.adapters.persistence.JpaEptDocRepository;
import co.integrapps.services.adapters.web.dto.EptDocValidationDto;
import co.integrapps.services.application.port.in.ValidateEptDocBarcodePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ValidationServiceEptDoc implements ValidateEptDocBarcodePort {
    private final JpaEptDocRepository repository;

    @Override
    public EptDocValidationDto validate(String barcode) {
        List<JpaEptDoc> docs = repository.findAllByBarcodehEquals(barcode);
        if(docs.isEmpty()){
            return new EptDocValidationDto(null, "documento no válido", false);
        }
        return new EptDocValidationDto(docs.get(0).getIdeptdoc(), null, true);
    }
}
