package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.repository.JpaEncuestaSatisfaccion;
import co.integrapps.services.application.port.in.PostCreateEncuestaUseCase;
import co.integrapps.services.application.port.in.PostSaveAllEncuestaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostSaveAllEncuestaService implements PostSaveAllEncuestaUseCase {
    private final PostCreateEncuestaUseCase service;

    @Override
    @Transactional
    public void execute(List<JpaEncuestaSatisfaccion> encuestas) {
        encuestas.forEach(service::saveEncuesta);
    }
}
