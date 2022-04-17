package co.integrapps.services.adapters.web;

import co.integrapps.services.adapters.persistence.repository.JpaEncuestaSatisfaccion;
import co.integrapps.services.adapters.web.dto.ResponseEncuestaDto;
import co.integrapps.services.application.port.in.PostCreateEncuestaUseCase;
import co.integrapps.services.application.port.in.PostSaveAllEncuestaUseCase;
import co.integrapps.services.application.port.out.S3BucketStoragePort;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

@RestController
@Api(value = "create encuestra controller")
@RequestMapping("/encuesta")
@Validated
@CrossOrigin("*")
public class PostCreateEncuestaController {
    @Autowired
    private S3BucketStoragePort bucket;
    @Autowired
    private PostCreateEncuestaUseCase postCreateEncuestaUseCaseService;
    @Autowired
    private PostSaveAllEncuestaUseCase postSaveAllEncuestaService;

    @ApiOperation(
            httpMethod = "POST",
            value = "create encuesta",
            response = ResponseEncuestaDto.class
    )
    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEncuestaDto createEncuesta(@RequestParam String body, @RequestParam(required = false) MultipartFile file){
        JpaEncuestaSatisfaccion encuesta = new Gson().fromJson(body, JpaEncuestaSatisfaccion.class);
        String message = postCreateEncuestaUseCaseService.saveEncuesta(encuesta);
        if(Objects.nonNull(file)){
            bucket.uploadFile(encuesta.getEncuestaId().toString(), file);
        }
        return ResponseEncuestaDto.builder().message(message).build();
    }


    @ApiOperation(
            httpMethod = "POST",
            value = "save all encuestas",
            response = ResponseEncuestaDto.class
    )
    @RequestMapping(
            value = "/save/all",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String saveAll(@RequestBody List<JpaEncuestaSatisfaccion> body){
        postSaveAllEncuestaService.execute(body);
        return "ok generado";
    }
}
