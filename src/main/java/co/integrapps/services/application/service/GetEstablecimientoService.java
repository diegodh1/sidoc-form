package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.repository.JpaEncuestaSatisfaccion;
import co.integrapps.services.adapters.persistence.repository.JpaEncuestaSatisfaccionRepository;
import co.integrapps.services.application.port.in.GetEstablecimientoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetEstablecimientoService implements GetEstablecimientoUseCase {
    private final JpaEncuestaSatisfaccionRepository encuestaRepository;

    @Override
    public List<JpaEncuestaSatisfaccion> getEstablecimientoByName(String name) {
        return encuestaRepository.filterByName(name);
    }
}
