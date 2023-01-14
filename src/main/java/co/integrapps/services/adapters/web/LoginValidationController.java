package co.integrapps.services.adapters.web;

import co.integrapps.services.adapters.web.dto.LoginRequestDto;
import co.integrapps.services.adapters.web.dto.LoginResponseDto;
import co.integrapps.services.application.port.in.RequestLoginPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoginValidationController {

    private final RequestLoginPort service;


    @PostMapping(
            value = "/validate",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public LoginResponseDto postBody(@RequestBody LoginRequestDto request) {
        return service.validate(request.getUsername(), request.getPassword());
    }
}
