package co.integrapps.services.adapters.web;

import co.integrapps.services.adapters.persistence.repository.*;
import co.integrapps.services.application.port.in.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "invoices to negotiate controller")
@RequestMapping("/information")
@Validated
@CrossOrigin("*")
public class GetInformationController {
    @Autowired
    private GetBarridosUseCase barridos;
    @Autowired
    private GetMarcaProveedorUseCase marcaProveedor;
    @Autowired
    private GetModalidadesEntregaUseCase modalidadesEntrega;

    @ApiOperation(
            value = "find all barridos",
            response = List.class,
            httpMethod = "GET"
    )
    @RequestMapping(
            value = "/barridos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<JpaBarrido> findAllBarridos(){
        return barridos.getAll();
    }

    @ApiOperation(
            value = "find all marca proveedor",
            response = List.class,
            httpMethod = "GET"
    )
    @RequestMapping(
            value = "/proveedor",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<JpaMarcaProveedor> findAllMarcaProveedor(){
        return marcaProveedor.getAll();
    }

    @ApiOperation(
            value = "find all modalidad entrega",
            response = List.class,
            httpMethod = "GET"
    )
    @RequestMapping(
            value = "/modalidad",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<JpaModalidadEntrega> findAllModalidad(){
        return modalidadesEntrega.getAll();
    }
}
