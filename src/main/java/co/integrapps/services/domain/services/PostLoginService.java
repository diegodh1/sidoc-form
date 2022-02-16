package co.integrapps.services.domain.services;

import co.integrapps.services.adapters.rest.dto.ResponseDto;
import co.integrapps.services.application.ports.in.PostLogin;
import co.integrapps.services.application.ports.out.SidocRestClientPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostLoginService implements PostLogin {
    @Autowired
    private SidocRestClientPort sidocRepository;

    @Override
    public ResponseDto requestLogin(String username, String password) {
        return sidocRepository.makeLoginRequest(username, password);
    }
}
