package co.integrapps.services.adapters.web;

import co.integrapps.services.adapters.rest.dto.ResponseDto;
import co.integrapps.services.application.ports.in.GetClientInformation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "client controller")
@RequestMapping("/client")
@Validated
public class ClientController {
    @Autowired
    private GetClientInformation getClientInformation;

    @ApiOperation(
            httpMethod = "GET",
            value = "get client information method",
            response = ResponseDto.class
    )
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseDto login(@RequestParam String clientId){
        return getClientInformation.getClientInformation(clientId);
    }
}