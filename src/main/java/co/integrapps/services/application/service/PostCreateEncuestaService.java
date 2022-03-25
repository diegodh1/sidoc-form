package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.repository.JpaEncuestaProveedorRepository;
import co.integrapps.services.adapters.persistence.repository.JpaEncuestaSatisfaccion;
import co.integrapps.services.adapters.persistence.repository.JpaEncuestaSatisfaccionRepository;
import co.integrapps.services.application.port.in.PostCreateEncuestaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostCreateEncuestaService implements PostCreateEncuestaUseCase {
    private final JpaEncuestaSatisfaccionRepository encuestaRepository;
    private final JpaEncuestaProveedorRepository proveedorRepository;
    @Override
    public String saveEncuesta(JpaEncuestaSatisfaccion encuestaSatisfaccion) {
        try {
            JpaEncuestaSatisfaccion response = encuestaRepository.save(encuestaSatisfaccion);
            encuestaSatisfaccion.getProveedores().forEach(proveedor -> proveedor.setEncuesta(JpaEncuestaSatisfaccion.builder().encuestaId(response.getEncuestaId()).build()));
            if(!encuestaSatisfaccion.getProveedores().isEmpty()){
                proveedorRepository.saveAll(encuestaSatisfaccion.getProveedores());
            }
            return "encuesta generada con éxito";
        } catch (Exception error){
            return error.getMessage();
        }
    }
}
