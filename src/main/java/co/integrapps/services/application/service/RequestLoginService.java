package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.JpaUser;
import co.integrapps.services.adapters.persistence.JpaUserRepository;
import co.integrapps.services.adapters.web.dto.LoginResponseDto;
import co.integrapps.services.application.port.in.RequestLoginPort;
import co.integrapps.services.application.service.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequestLoginService implements RequestLoginPort {
    private final JpaUserRepository repository;
    private final UserMapper mapper;

    @Override
    public LoginResponseDto validate(String username, String password) {
        Optional<JpaUser> user = repository.findByStrusuarioEqualsAndStrpasswordEquals(username, password);
        if(user.isPresent()){
            return LoginResponseDto.builder()
                    .success(true)
                    .data(mapper.toDto(user.get()))
                    .build();
        }
        return LoginResponseDto.builder()
                .success(false)
                .error("Usuario y/o contraseña invalido")
                .build();
    }
}
