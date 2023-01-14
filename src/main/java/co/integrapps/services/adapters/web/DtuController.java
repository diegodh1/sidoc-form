package co.integrapps.services.adapters.web;

import co.integrapps.services.adapters.web.dto.DtuRequestDto;
import co.integrapps.services.adapters.web.dto.DtuResponseDto;
import co.integrapps.services.adapters.web.dto.EptDocValidationDto;
import co.integrapps.services.application.port.in.SaveDtuPort;
import co.integrapps.services.application.service.ValidationServiceEptDoc;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DtuController {
    private final SaveDtuPort service;


    @PostMapping(
            value = "/dtu",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public DtuResponseDto postBody(@RequestBody DtuRequestDto request) {
        try {
            return service.execute(request);
        } catch (DataAccessException e) {
            Throwable cause = e.getCause();
            return new DtuResponseDto(null, false,
                    String.format("Error al guardar DTU %s", e.getMostSpecificCause().getMessage()));
        }
    }
}
