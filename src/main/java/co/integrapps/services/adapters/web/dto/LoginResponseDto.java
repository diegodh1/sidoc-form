package co.integrapps.services.adapters.web.dto;

import co.integrapps.services.adapters.persistence.repository.JpaUsuario;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDto {
    private JpaUsuario user;
    private Boolean success;
    private String message;
}
