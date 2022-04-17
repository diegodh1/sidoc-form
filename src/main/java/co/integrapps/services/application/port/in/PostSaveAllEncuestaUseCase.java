package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.persistence.repository.JpaEncuestaSatisfaccion;

import java.util.List;

public interface PostSaveAllEncuestaUseCase {
    void execute(List<JpaEncuestaSatisfaccion> encuestas);
}
