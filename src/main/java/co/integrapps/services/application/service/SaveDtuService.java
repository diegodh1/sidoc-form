package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.JpaDtu;
import co.integrapps.services.adapters.persistence.JpaDtuDetalle;
import co.integrapps.services.adapters.persistence.JpaDtuDetalleRepository;
import co.integrapps.services.adapters.persistence.JpaDtuRepository;
import co.integrapps.services.adapters.web.dto.DtuRequestDto;
import co.integrapps.services.adapters.web.dto.DtuResponseDto;
import co.integrapps.services.application.port.in.SaveDtuPort;
import co.integrapps.services.application.service.mappers.DtuMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class SaveDtuService implements SaveDtuPort {
    private final DtuMapper mapper;
    private final JpaDtuRepository dtuRepository;
    private final JpaDtuDetalleRepository dtuDetalleRepository;
    @Override
    public DtuResponseDto execute(DtuRequestDto request) {
        JpaDtu dtu = mapper.toDtuJpa(request);
        dtu.setDtuestado(1);
        dtu.setDtufechacrea(new Date());
        dtu.setDtumodifica(new Date());
        JpaDtu newRecord = dtuRepository.save(dtu);
        newRecord.setDtubarcode(convertToDtuFormat(newRecord.getIddtu()));
        JpaDtuDetalle dtuDetalle = mapper.toDtuDetalleJpa(request);
        dtuDetalle.setDetDtuIdDoc(newRecord.getIddtu());
        dtuDetalleRepository.save(dtuDetalle);
        return new DtuResponseDto(String.format("registro realizado con éxito, dtu #%d",newRecord.getIddtu()),
                true,
                null);
    }

    public String convertToDtuFormat(int num) {
        String str = String.format("%010d", num);
        return "DTU" + str;
    }
}
