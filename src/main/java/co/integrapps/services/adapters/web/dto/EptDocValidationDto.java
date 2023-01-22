package co.integrapps.services.adapters.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EptDocValidationDto {
    private Integer data;
    private String error;
    private Boolean success;
}
