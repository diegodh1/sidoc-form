package co.integrapps.services.adapters.web;

import co.integrapps.services.adapters.rest.dto.ResponseDto;
import co.integrapps.services.adapters.rest.dto.UserDto;
import co.integrapps.services.application.ports.in.GetClientInformation;
import co.integrapps.services.application.ports.in.PostLogin;
import co.integrapps.services.application.ports.out.SidocRestClientPort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;


@RestController
@Api(value = "login controller")
@RequestMapping("/login")
@Validated
public class LoginController {
    @Autowired
    private PostLogin postLogin;
    @Autowired
    private GetClientInformation getClientInformation;

    @ApiOperation(
            httpMethod = "POST",
            value = "login method",
            response = ResponseDto.class
    )
    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseDto login(@RequestBody UserDto userDto){
        return postLogin.requestLogin(userDto.getUserId(), userDto.getPassword());
    }
}
