package co.integrapps.services.application.port.out;

import co.integrapps.services.adapters.rest.dto.ResponseDto;

public interface SidocRestClientPort {
    ResponseDto makeLoginRequest(String username, String password);
}
