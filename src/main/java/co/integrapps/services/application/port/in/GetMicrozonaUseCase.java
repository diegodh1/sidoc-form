package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.persistence.repository.JpaMarcaProveedor;
import co.integrapps.services.adapters.persistence.repository.JpaMicrozona;

import java.util.List;

public interface GetMicrozonaUseCase {
    List<JpaMicrozona> getAll();
}
