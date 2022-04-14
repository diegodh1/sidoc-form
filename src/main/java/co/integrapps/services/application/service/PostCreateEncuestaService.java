package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.repository.JpaEncuestaProveedor;
import co.integrapps.services.adapters.persistence.repository.JpaEncuestaProveedorRepository;
import co.integrapps.services.adapters.persistence.repository.JpaEncuestaSatisfaccion;
import co.integrapps.services.adapters.persistence.repository.JpaEncuestaSatisfaccionRepository;
import co.integrapps.services.application.port.in.PostCreateEncuestaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@AllArgsConstructor
public class PostCreateEncuestaService implements PostCreateEncuestaUseCase {
    private final JpaEncuestaSatisfaccionRepository encuestaRepository;
    private final JpaEncuestaProveedorRepository proveedorRepository;

    @Override
    @Transactional
    public String saveEncuesta(JpaEncuestaSatisfaccion encuestaSatisfaccion) {
        try {
            Set<JpaEncuestaProveedor> proveedores = encuestaSatisfaccion.getProveedores();
            encuestaSatisfaccion.setProveedores(null);
            JpaEncuestaSatisfaccion response = encuestaRepository.save(encuestaSatisfaccion);
            proveedores.forEach(proveedor -> proveedor.setEncuesta(JpaEncuestaSatisfaccion.builder().encuestaId(response.getEncuestaId()).build()));
            proveedorRepository.deleteAllByEncuestaEncuestaId(encuestaSatisfaccion.getEncuestaId());
            if(!proveedores.isEmpty()){
                proveedorRepository.saveAll(proveedores);
            }
            return "encuesta generada con éxito";
        } catch (Exception error){
            return error.getMessage();
        }
    }
}
