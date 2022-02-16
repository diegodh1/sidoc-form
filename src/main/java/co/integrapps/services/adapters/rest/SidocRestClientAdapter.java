package co.integrapps.services.adapters.rest;
import co.integrapps.services.adapters.rest.dto.ResponseDto;
import co.integrapps.services.adapters.rest.dto.UserDto;
import co.integrapps.services.application.ports.out.SidocRestClientPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Repository
public class SidocRestClientAdapter implements SidocRestClientPort {
    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${sidoc.rest.url}")
    private String baseUrl;
    @Value("${sidoc.rest.methods.login}")
    private String loginMethod;
    @Value("${sidoc.rest.methods.client-info}")
    private String requestClientInfoMethod;



    @Override
    public ResponseDto makeLoginRequest(String username, String password) {
        UserDto body = UserDto.builder().userId(username).password(password).build();
        HttpEntity<UserDto> request = new HttpEntity<>(body);
        return restTemplate.postForObject(baseUrl.concat(loginMethod), request, ResponseDto.class);
    }

    @Override
    public ResponseDto getClientInformation(String clientId) {
        try {
            return restTemplate.getForObject(baseUrl.concat(requestClientInfoMethod + String.format("/%s", clientId)), ResponseDto.class);
        }
        catch (HttpClientErrorException error){
            return ResponseDto.builder().message(error.getMessage()).status(404).build();
        }
    }
}
