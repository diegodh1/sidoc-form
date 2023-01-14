package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.web.dto.EptValidationResponse;

public interface ValidateEptBarcodePort {

    EptValidationResponse validate(String barcode, Integer docId);
}
