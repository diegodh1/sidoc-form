package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.persistence.repository.JpaUsuario;
import co.integrapps.services.adapters.web.dto.LoginResponseDto;

public interface PostSaveUserUseCase {
    LoginResponseDto save(JpaUsuario user);
}
