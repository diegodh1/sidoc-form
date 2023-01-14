package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.web.dto.DtuRequestDto;
import co.integrapps.services.adapters.web.dto.DtuResponseDto;

public interface SaveDtuPort {
    DtuResponseDto execute(DtuRequestDto request);
}
