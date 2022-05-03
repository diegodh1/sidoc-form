package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.repository.JpaEncuestaProveedorRepository;
import co.integrapps.services.adapters.persistence.repository.JpaEncuestaSatisfaccionRepository;
import co.integrapps.services.application.port.in.DeleteRecordUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class DeleteRecordService implements DeleteRecordUseCase {
    private final JpaEncuestaProveedorRepository encuestaProveedorRepository;
    private final JpaEncuestaSatisfaccionRepository encuestaRepository;

    @Override
    @Transactional
    public String execute(Integer recordId) {
        try {
            encuestaProveedorRepository.deleteAllByEncuestaEncuestaId(recordId);
            encuestaRepository.deleteAllByEncuestaId(recordId);
            return "Registro eliminado con éxito";
        } catch (Exception error){
            return String.format("Error: %s", error.getMessage());
        }
    }
}
