package co.integrapps.services.domain.services;

import co.integrapps.services.adapters.rest.dto.ResponseDto;
import co.integrapps.services.application.ports.in.GetClientInformation;
import co.integrapps.services.application.ports.out.SidocRestClientPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetClientInformationService implements GetClientInformation {
    @Autowired
    private SidocRestClientPort sidocRepository;

    @Override
    public ResponseDto getClientInformation(String clientId) {
        return sidocRepository.getClientInformation(clientId);
    }
}
