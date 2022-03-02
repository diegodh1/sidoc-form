package co.integrapps.services.adapters.web;

import co.integrapps.services.adapters.persistence.InvoiceJpaEntity;
import co.integrapps.services.adapters.rest.dto.UserDto;
import co.integrapps.services.application.port.in.GetInvoicesToNegotiateUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "invoices controller")
@RequestMapping("/invoices")
@Validated
public class GetInvoiceToNegotiateController {
    @Autowired
    private GetInvoicesToNegotiateUseCase getInvoicesToNegotiateUseCase;

    @ApiOperation(
            httpMethod = "GET",
            value = "get all invoices to negotiate",
            response = List.class
    )
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<InvoiceJpaEntity> getAllInvoices(){
        return getInvoicesToNegotiateUseCase.getAllInvoices();
    }
}
