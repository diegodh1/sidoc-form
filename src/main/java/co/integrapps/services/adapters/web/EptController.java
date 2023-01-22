package co.integrapps.services.adapters.web;

import co.integrapps.services.adapters.web.dto.EptValidationResponse;
import co.integrapps.services.application.service.ValidationServiceEpt;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;


@Data
@Validated
class EptRequest{
    @NotNull
    private Integer docId;
    @NotNull
    private String barcode;
}


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EptController {

    private final ValidationServiceEpt service;

    @PostMapping(
            value = "validate/ept/item",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public EptValidationResponse postBody(@RequestBody EptRequest request) {
        return service.validate(request.getBarcode(), request.getDocId());
    }
}
