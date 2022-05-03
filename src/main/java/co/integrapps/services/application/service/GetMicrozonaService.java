package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.repository.JpaMicrozona;
import co.integrapps.services.adapters.persistence.repository.JpaMicrozonaRepository;
import co.integrapps.services.adapters.persistence.repository.JpaModalidadEntrega;
import co.integrapps.services.adapters.persistence.repository.JpaModalidadEntregaRepository;
import co.integrapps.services.application.port.in.GetMicrozonaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetMicrozonaService implements GetMicrozonaUseCase {
    private final JpaMicrozonaRepository repository;
    @Override
    public List<JpaMicrozona> getAll() {
        return repository.findAllByActivoTrue();
    }
}
