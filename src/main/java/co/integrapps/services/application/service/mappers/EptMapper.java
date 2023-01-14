package co.integrapps.services.application.service.mappers;

import co.integrapps.services.adapters.persistence.JpaEpt;
import co.integrapps.services.adapters.web.dto.EptValidationDataDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EptMapper {

    @Mapping(target="idEpt", source="idept")
    @Mapping(target="idEptDoc", source="ideptdoc")
    @Mapping(target="item", source="item")
    @Mapping(target="barCode", source="barcodeh")
    @Mapping(target="idBodegaDestino", source="idbodegadestino")
    @Mapping(target="bodega", source="strbodega")
    @Mapping(target="ubicacion", source="strubicacion")
    @Mapping(target="localizacion", source="strlocalizacion")
    EptValidationDataDto toDto(JpaEpt source);
}
