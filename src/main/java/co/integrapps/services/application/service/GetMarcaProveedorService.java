package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.repository.JpaMarcaProveedor;
import co.integrapps.services.adapters.persistence.repository.JpaMarcaProveedorRepository;
import co.integrapps.services.application.port.in.GetMarcaProveedorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetMarcaProveedorService implements GetMarcaProveedorUseCase {
    private final JpaMarcaProveedorRepository repository;

    @Override
    public List<JpaMarcaProveedor> getAll() {
        return repository.findAllByActivoTrue();
    }
}
