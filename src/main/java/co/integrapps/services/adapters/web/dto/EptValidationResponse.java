package co.integrapps.services.adapters.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EptValidationResponse {
    private Boolean success;
    private EptValidationDataDto data;
    private String error;
}
