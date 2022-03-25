package co.integrapps.services.adapters.web.dto;

import co.integrapps.services.adapters.persistence.repository.JpaEncuestaSatisfaccion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEncuestasDto {
    private List<JpaEncuestaSatisfaccion> encuestas;
}
