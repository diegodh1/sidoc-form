package co.integrapps.services.adapters.web;

import co.integrapps.services.adapters.persistence.repository.JpaUsuario;
import co.integrapps.services.adapters.web.dto.LoginResponseDto;
import co.integrapps.services.application.port.in.PostSaveUserUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(value = "create or update user")
@CrossOrigin("*")
public class PostSaveUserController {
    @Autowired
    private PostSaveUserUseCase service;

    @ApiOperation(
            httpMethod = "POST",
            response = LoginResponseDto.class,
            value = "save user")
    @RequestMapping(
            value = "/save",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public LoginResponseDto save(@RequestBody JpaUsuario user){
        return service.save(user);
    }
}
