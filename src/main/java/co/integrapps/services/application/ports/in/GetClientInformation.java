package co.integrapps.services.application.ports.in;

import co.integrapps.services.adapters.rest.dto.ResponseDto;

public interface GetClientInformation {
    ResponseDto getClientInformation(String clientId);
}
