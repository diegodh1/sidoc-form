package co.integrapps.services.application.service.mappers;

import co.integrapps.services.adapters.persistence.JpaUser;
import co.integrapps.services.adapters.web.dto.LoginDataDto;
import co.integrapps.services.adapters.web.dto.LoginResponseDto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target="username", source="strusuario")
    @Mapping(target="name", source="strnombre")
    @Mapping(target="email", source="stremail")
    LoginDataDto toDto(JpaUser source);
}
