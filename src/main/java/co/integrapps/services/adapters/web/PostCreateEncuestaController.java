package co.integrapps.services.adapters.web;

import co.integrapps.services.adapters.persistence.repository.JpaEncuestaSatisfaccion;
import co.integrapps.services.adapters.web.dto.ResponseEncuestaDto;
import co.integrapps.services.adapters.web.dto.ResponseNegotiateInvoiceDto;
import co.integrapps.services.application.port.in.PostCreateEncuestaUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "invoices to negotiate controller")
@RequestMapping("/encuesta")
@Validated
@CrossOrigin("*")
public class PostCreateEncuestaController {
    @Autowired
    private PostCreateEncuestaUseCase postCreateEncuestaUseCaseService;

    @ApiOperation(
            httpMethod = "POST",
            value = "create encuesta",
            response = ResponseNegotiateInvoiceDto.class
    )
    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEncuestaDto createEncuesta(@RequestBody JpaEncuestaSatisfaccion body){
        String message = postCreateEncuestaUseCaseService.saveEncuesta(body);
        return ResponseEncuestaDto.builder().message(message).build();
    }
}
