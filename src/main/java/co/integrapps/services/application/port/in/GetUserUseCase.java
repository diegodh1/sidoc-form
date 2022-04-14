package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.persistence.repository.JpaUsuario;

import java.util.List;

public interface GetUserUseCase {
    List<JpaUsuario> findAllByName(String name);
}
