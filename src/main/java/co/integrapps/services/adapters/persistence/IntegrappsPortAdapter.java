package co.integrapps.services.adapters.persistence;

import co.integrapps.services.adapters.persistence.repository.JpaNegotiatedInvoiceRepository;
import co.integrapps.services.adapters.persistence.repository.JpaUserOmnilatam;
import co.integrapps.services.adapters.persistence.repository.JpaUserOmnilatamRepository;
import co.integrapps.services.application.port.out.IntegrappsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IntegrappsPortAdapter implements IntegrappsPort {
    private final JpaUserOmnilatamRepository jpaUserOmnilatamRepository;

    @Override
    public boolean validateUser(String username, String password) {
        JpaUserOmnilatam user = jpaUserOmnilatamRepository.getByIsActiveAndUsernameAndPasswrd(true, username, password);
        return user == null;
    }
}
