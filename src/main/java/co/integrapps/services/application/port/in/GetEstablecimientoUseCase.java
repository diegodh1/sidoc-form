package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.persistence.repository.JpaEncuestaSatisfaccion;

import java.util.List;

public interface GetEstablecimientoUseCase {
    List<JpaEncuestaSatisfaccion> getEstablecimientoByName(String name);
}
