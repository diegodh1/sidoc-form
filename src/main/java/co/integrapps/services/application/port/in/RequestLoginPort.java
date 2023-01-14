package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.web.dto.LoginResponseDto;

public interface RequestLoginPort {
    LoginResponseDto validate(String username, String password);
}
