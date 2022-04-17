package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.repository.JpaBarrido;
import co.integrapps.services.adapters.persistence.repository.JpaBarridoRepository;
import co.integrapps.services.application.port.in.GetBarridosUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetBarridoService implements GetBarridosUseCase {

    private final JpaBarridoRepository barridoRepository;

    @Override
    public List<JpaBarrido> getAll() {
        return barridoRepository.findAllByActivoTrue();
    }
}
