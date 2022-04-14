package co.integrapps.services.adapters.web;

import co.integrapps.services.adapters.persistence.repository.JpaUsuario;
import co.integrapps.services.application.port.in.GetUserUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "get all users")
@Validated
@CrossOrigin("*")
public class GetUserController {
    @Autowired
    private GetUserUseCase service;

    @ApiOperation(
            value = "find users by name",
            response = List.class,
            httpMethod = "GET"
    )
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<JpaUsuario> findAllByName(@RequestParam String name){
        return service.findAllByName(name);
    }
}
