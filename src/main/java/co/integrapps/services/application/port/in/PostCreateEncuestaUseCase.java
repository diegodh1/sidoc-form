package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.persistence.repository.JpaEncuestaSatisfaccion;

public interface PostCreateEncuestaUseCase {
    String saveEncuesta(JpaEncuestaSatisfaccion encuestaSatisfaccion);
}
