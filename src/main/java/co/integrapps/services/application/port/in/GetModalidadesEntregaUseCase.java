package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.persistence.repository.JpaModalidadEntrega;

import java.util.List;

public interface GetModalidadesEntregaUseCase {
    List<JpaModalidadEntrega> getAll();
}
