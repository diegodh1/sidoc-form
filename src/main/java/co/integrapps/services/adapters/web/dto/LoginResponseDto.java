package co.integrapps.services.adapters.web.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private Boolean success;
    private LoginDataDto data;
    private String error;
}
