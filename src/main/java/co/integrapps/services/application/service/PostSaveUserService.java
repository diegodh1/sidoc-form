package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.repository.JpaUsuario;
import co.integrapps.services.adapters.persistence.repository.JpaUsuarioRepository;
import co.integrapps.services.adapters.web.dto.LoginResponseDto;
import co.integrapps.services.application.port.in.PostSaveUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PostSaveUserService implements PostSaveUserUseCase {
    private final JpaUsuarioRepository repository;

    @Override
    public LoginResponseDto save(JpaUsuario user) {
        try {
            user.setUpdatedAt(new Date());
            JpaUsuario result = repository.save(user);
            return LoginResponseDto.builder().user(result).success(true).message("Usuario registrado con éxito").build();
        } catch (Exception error){
            return LoginResponseDto.builder().success(false).message("Ha ocurrido un error: " + error.getMessage()).build();
        }
    }
}
