package co.integrapps.services.adapters.web;

import co.integrapps.services.adapters.persistence.repository.JpaEncuestaSatisfaccion;
import co.integrapps.services.adapters.web.dto.ResponseEncuestaDto;
import co.integrapps.services.application.port.in.DeleteRecordUseCase;
import co.integrapps.services.application.port.in.PostSaveAllEncuestaUseCase;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
@Api(value = "create encuestra controller")
@RequestMapping("/encuesta")
@Validated
@CrossOrigin("*")
public class DeleteEncuestaController {
    @Autowired
    private DeleteRecordUseCase service;

    @ApiOperation(
            httpMethod = "DELETE",
            value = "create encuesta",
            response = ResponseEncuestaDto.class
    )
    @RequestMapping(
            value = "/delete/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEncuestaDto deleteEncuesta(@PathVariable Integer id){
        String response = service.execute(id);
        return ResponseEncuestaDto.builder().message(response).build();
    }
}
