package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.persistence.repository.JpaBarrido;

import java.util.List;

public interface GetBarridosUseCase {
    List<JpaBarrido> getAll();
}
