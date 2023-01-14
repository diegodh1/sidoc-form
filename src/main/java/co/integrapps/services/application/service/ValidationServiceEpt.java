package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.JpaEpt;
import co.integrapps.services.adapters.persistence.JpaEptRepository;
import co.integrapps.services.adapters.web.dto.EptValidationDataDto;
import co.integrapps.services.adapters.web.dto.EptValidationResponse;
import co.integrapps.services.application.port.in.ValidateEptBarcodePort;
import co.integrapps.services.application.service.mappers.EptMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ValidationServiceEpt implements ValidateEptBarcodePort {
    private final JpaEptRepository repository;
    private final EptMapper mapper;

    @Override
    public EptValidationResponse validate(String barcode, Integer docId) {
        List<JpaEpt> epts = repository.findAllByBarcodehEqualsAndIdeptdocEquals(barcode, docId);
        if(!epts.isEmpty()){
            EptValidationDataDto ept = mapper.toDto(epts.get(0));
            ept.setCantidadPorEnviar(epts.get(0).getCantenviada() - epts.get(0).getCantubicada());
            return EptValidationResponse.builder()
                    .success(true)
                    .data(ept)
                    .build();
        }

        return EptValidationResponse.builder()
                .success(false)
                .error("El código enviado no es válido")
                .build();
    }
}
