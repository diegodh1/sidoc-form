package co.integrapps.services.application.ports.in;

import co.integrapps.services.adapters.rest.dto.ResponseDto;

public interface PostLogin {
    ResponseDto requestLogin(String username, String password);
}
