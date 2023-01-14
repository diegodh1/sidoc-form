package co.integrapps.services.adapters.web.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class DtuRequestDto {
    private Integer idEpt;
    private Integer idEptDoc;
    private Integer item;
    private String barCode;
    private Float cantidadPorEnviar;
    private Integer idBodegaDestino;
    private String bodega;
    private String ubicacion;
    private String localizacion;
    private String username;
}
