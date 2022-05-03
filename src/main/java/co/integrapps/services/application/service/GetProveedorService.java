package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.repository.JpaMicrozona;
import co.integrapps.services.adapters.persistence.repository.JpaMicrozonaRepository;
import co.integrapps.services.adapters.persistence.repository.JpaProveedor;
import co.integrapps.services.adapters.persistence.repository.JpaProveedorRepository;
import co.integrapps.services.application.port.in.GetProveedorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetProveedorService implements GetProveedorUseCase {
    private final JpaProveedorRepository repository;
    @Override
    public List<JpaProveedor> getAll() {
        return repository.findAllByActivoTrue();
    }
}
