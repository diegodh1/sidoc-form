package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.web.dto.DtuRequestDto;
import co.integrapps.services.adapters.web.dto.DtuResponseDto;

import javax.transaction.Transactional;

public interface SaveDtuPort {
    @Transactional
    DtuResponseDto execute(DtuRequestDto request);
}
