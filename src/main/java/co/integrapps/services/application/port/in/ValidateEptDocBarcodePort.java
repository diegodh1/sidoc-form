package co.integrapps.services.application.port.in;

import co.integrapps.services.adapters.web.dto.EptDocValidationDto;

public interface ValidateEptDocBarcodePort {
    EptDocValidationDto validate(String barcode);
}
