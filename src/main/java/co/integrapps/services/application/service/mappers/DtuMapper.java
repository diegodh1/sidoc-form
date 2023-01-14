package co.integrapps.services.application.service.mappers;

import co.integrapps.services.adapters.persistence.JpaDtu;
import co.integrapps.services.adapters.persistence.JpaDtuDetalle;
import co.integrapps.services.adapters.persistence.JpaEpt;
import co.integrapps.services.adapters.web.dto.DtuRequestDto;
import co.integrapps.services.adapters.web.dto.EptValidationDataDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DtuMapper {

    @Mapping(target="dtuusu", source="username")
    @Mapping(target="dtubodorigen", source="bodega")
    @Mapping(target="ideptdoc", source="idEptDoc")
    JpaDtu toDtuJpa(DtuRequestDto source);

    @Mapping(target="detDtuItem", source="item")
    @Mapping(target="detDtuCant", source="cantidadPorEnviar")
    @Mapping(target="detDtuEstante", source="localizacion")
    @Mapping(target="detDtuUbica", source="localizacion")
    JpaDtuDetalle toDtuDetalleJpa(DtuRequestDto source);
}
