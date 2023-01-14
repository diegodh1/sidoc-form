package co.integrapps.services.adapters.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtuResponseDto {
    private String data;
    private Boolean success;
    private String error;
}
