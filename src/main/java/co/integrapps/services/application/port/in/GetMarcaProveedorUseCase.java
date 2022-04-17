package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.persistence.repository.JpaMarcaProveedor;

import java.util.List;

public interface GetMarcaProveedorUseCase {
    List<JpaMarcaProveedor> getAll();
}
