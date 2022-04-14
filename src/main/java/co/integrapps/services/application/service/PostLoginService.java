package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.repository.JpaUsuario;
import co.integrapps.services.adapters.persistence.repository.JpaUsuarioRepository;
import co.integrapps.services.adapters.web.dto.LoginResponseDto;
import co.integrapps.services.application.port.in.PostLoginUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostLoginService implements PostLoginUseCase {
    private final JpaUsuarioRepository repository;

    @Override
    public LoginResponseDto execute(String userId, String password) {
        JpaUsuario user = repository.findByUserIdAndPassword(userId, password);
        if(Objects.nonNull(user)){
            if(user.getIsActive()){
                return LoginResponseDto.builder().success(true).message("ingreso realizado").user(user).build();
            } else{
                return LoginResponseDto.builder().success(false).message("Usuario inactivo en el sistema").build();
            }
        }
        return LoginResponseDto.builder().success(false).message("Usuario y/o contraseña incorrectos").build();
    }
}
