package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.*;
import co.integrapps.services.adapters.web.dto.DtuRequestDto;
import co.integrapps.services.adapters.web.dto.DtuResponseDto;
import co.integrapps.services.application.port.in.SaveDtuPort;
import co.integrapps.services.application.service.mappers.DtuMapper;
import co.integrapps.services.config.CustomTransactionalException;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class SaveDtuService implements SaveDtuPort {
    private final DtuMapper mapper;
    private final JpaDtuRepository dtuRepository;
    private final JpaDtuDetalleRepository dtuDetalleRepository;
    private final JpaEventoRepository eventoRepository;

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRES_NEW)
    public DtuResponseDto execute(DtuRequestDto request) {
        JpaDtu dtu = mapper.toDtuJpa(request);
        dtu.setDtubarcode("");
        dtu.setDtuestado(1);
        dtu.setDtufechacrea(new Date());
        dtu.setDtumodifica(new Date());
        JpaDtu newRecord = dtuRepository.save(dtu);
        newRecord.setDtubarcode(convertToDtuFormat(newRecord.getIddtu()));
        JpaDtuDetalle dtuDetalle = mapper.toDtuDetalleJpa(request);
        dtuDetalle.setDetDtuIdDoc(newRecord.getIddtu());
        dtuDetalle.setDetDtuCanasta("1");
        dtuDetalleRepository.save(dtuDetalle);
        eventoRepository.save(JpaEvento.builder()
                .username(newRecord.getDtuusu())
                .fecha(getDate())
                .dtuDocId(String.valueOf(newRecord.getIddtu()))
                .tipoEvento("DTU")
                .build());
        return new DtuResponseDto(String.format("registro realizado con éxito, dtu #%d", newRecord.getIddtu()),
                true,
                null);
    }

    private String getDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(new Date());
    }

    private String convertToDtuFormat(int num) {
        String str = String.format("%010d", num);
        return "DTU" + str;
    }
}
