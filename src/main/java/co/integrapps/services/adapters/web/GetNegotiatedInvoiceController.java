package co.integrapps.services.adapters.web;

import co.integrapps.services.adapters.persistence.JpaNegotiatedInvoiceEntity;
import co.integrapps.services.adapters.web.dto.RequestNegotiateInvoicesDto;
import co.integrapps.services.application.port.in.GetNegotiatedInvoiceUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "negotiated invoices controller")
@RequestMapping("invoices/negotiated")
@Validated
public class GetNegotiatedInvoiceController {
    @Autowired
    private GetNegotiatedInvoiceUseCase getNegotiatedInvoiceService;

    @ApiOperation(
            httpMethod = "GET",
            value = "get all the negotiated invoices",
            response = List.class
    )
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RequestNegotiateInvoicesDto getAllNegotiatedInvoices(){
        return new RequestNegotiateInvoicesDto(getNegotiatedInvoiceService.getAllNegotiatedInvoice());
    }

}
