package co.integrapps.services.adapters.web;

import co.integrapps.services.adapters.persistence.repository.JpaEncuestaSatisfaccion;
import co.integrapps.services.adapters.web.dto.ResponseEncuestasDto;
import co.integrapps.services.application.port.in.GetEstablecimientoUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "invoices to negotiate controller")
@RequestMapping("/encuesta")
@Validated
@CrossOrigin("*")
public class GetEstablecimientoController {
    @Autowired
    private GetEstablecimientoUseCase getEstablecimientoService;

    @ApiOperation(
            httpMethod = "GET",
            value = "get all establecimientos by name or contacto",
            response = ResponseEncuestasDto.class
    )
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEncuestasDto getAllEstablecimientos(@RequestParam String text){
        List<JpaEncuestaSatisfaccion> response = getEstablecimientoService.getEstablecimientoByName(text);
        response.forEach(encuestaSatisfaccion -> encuestaSatisfaccion.setProveedores(null));
        return new ResponseEncuestasDto(response);
    }
}
