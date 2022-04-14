package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.web.dto.LoginResponseDto;

public interface PostLoginUseCase {
    LoginResponseDto execute(String userId, String password);
}
