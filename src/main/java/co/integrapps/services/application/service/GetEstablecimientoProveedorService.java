package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.repository.JpaEncuestaProveedor;
import co.integrapps.services.adapters.persistence.repository.JpaEncuestaProveedorRepository;
import co.integrapps.services.adapters.persistence.repository.JpaEncuestaSatisfaccion;
import co.integrapps.services.adapters.persistence.repository.JpaEncuestaSatisfaccionRepository;
import co.integrapps.services.application.port.in.GetEstablecimientoProveedor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetEstablecimientoProveedorService implements GetEstablecimientoProveedor {
    private final JpaEncuestaProveedorRepository encuestaProveedorRepository;

    @Override
    public List<JpaEncuestaProveedor> getProveedores(Integer encuestaId) {
        return encuestaProveedorRepository.findAllByEncuesta(JpaEncuestaSatisfaccion.builder().encuestaId(encuestaId).build());
    }
}
