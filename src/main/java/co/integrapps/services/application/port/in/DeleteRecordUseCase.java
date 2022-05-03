package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.persistence.repository.JpaEncuestaSatisfaccion;

public interface DeleteRecordUseCase {
    String execute(Integer recordId);
}
