package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.repository.JpaUsuario;
import co.integrapps.services.adapters.persistence.repository.JpaUsuarioRepository;
import co.integrapps.services.application.port.in.GetUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetUserService implements GetUserUseCase {
    private final JpaUsuarioRepository repository;
    @Override
    public List<JpaUsuario> findAllByName(String name) {
        return repository.findAllByNameContains(name);
    }
}
