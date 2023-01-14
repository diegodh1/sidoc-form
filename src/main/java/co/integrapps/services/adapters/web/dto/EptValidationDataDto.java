package co.integrapps.services.adapters.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EptValidationDataDto {
    private Integer idEpt;
    private Integer idEptDoc;
    private Integer item;
    private String barCode;
    private Float cantidadPorEnviar;
    private Integer idBodegaDestino;
    private String bodega;
    private String ubicacion;
    private String localizacion;
}
