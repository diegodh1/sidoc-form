package co.integrapps.services.adapters.web;

import co.integrapps.services.adapters.web.dto.EptDocValidationDto;
import co.integrapps.services.application.service.ValidationServiceEptDoc;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@Data
@Validated
class EptDocRequest{
    @NotNull
    private String barcode;
}

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EptDocController {

    private final ValidationServiceEptDoc service;


    @PostMapping(
            value = "/ept/doc",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public EptDocValidationDto postBody(@RequestBody EptDocRequest request) {
        return service.validate(request.getBarcode());
    }
}
