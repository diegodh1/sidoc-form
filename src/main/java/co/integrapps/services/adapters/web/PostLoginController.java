package co.integrapps.services.adapters.web;

import co.integrapps.services.adapters.web.dto.LoginRequestDto;
import co.integrapps.services.adapters.web.dto.LoginResponseDto;
import co.integrapps.services.application.port.in.PostLoginUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "post login controller")
@RequestMapping("/login")
@Validated
@CrossOrigin("*")
public class PostLoginController {
    @Autowired
    private PostLoginUseCase service;

    @ApiOperation(
            value = "login request",
            httpMethod = "POST",
            response = LoginResponseDto.class
    )
    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public LoginResponseDto login(@RequestBody LoginRequestDto user){
        return service.execute(user.getUserId(), user.getPassword());
    }
}
