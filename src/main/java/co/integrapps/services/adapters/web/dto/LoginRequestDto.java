package co.integrapps.services.adapters.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Validated
@Getter
@Setter
public class LoginRequestDto {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
