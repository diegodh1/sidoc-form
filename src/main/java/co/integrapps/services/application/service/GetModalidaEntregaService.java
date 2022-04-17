package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.repository.JpaModalidadEntrega;
import co.integrapps.services.adapters.persistence.repository.JpaModalidadEntregaRepository;
import co.integrapps.services.application.port.in.GetModalidadesEntregaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetModalidaEntregaService implements GetModalidadesEntregaUseCase {
    private final JpaModalidadEntregaRepository repository;
    @Override
    public List<JpaModalidadEntrega> getAll() {
        return repository.findAllByActivoTrue();
    }
}
