package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.persistence.repository.JpaEncuestaSatisfaccion;
import co.integrapps.services.adapters.persistence.repository.JpaNegotiatedInvoiceEntity;

import java.util.List;

public interface GetEstablecimientoUseCase {
    List<JpaEncuestaSatisfaccion> getEstablecimientoByName(String name);
}
