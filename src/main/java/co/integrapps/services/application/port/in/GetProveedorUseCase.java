package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.persistence.repository.JpaMicrozona;
import co.integrapps.services.adapters.persistence.repository.JpaProveedor;

import java.util.List;

public interface GetProveedorUseCase {
    List<JpaProveedor> getAll();
}
