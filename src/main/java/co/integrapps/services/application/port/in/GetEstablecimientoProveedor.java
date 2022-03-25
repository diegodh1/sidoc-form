package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.persistence.repository.JpaEncuestaProveedor;
import co.integrapps.services.adapters.persistence.repository.JpaEncuestaSatisfaccion;

import java.util.List;

public interface GetEstablecimientoProveedor {
    List<JpaEncuestaProveedor> getProveedores(Integer encuestaId);
}
