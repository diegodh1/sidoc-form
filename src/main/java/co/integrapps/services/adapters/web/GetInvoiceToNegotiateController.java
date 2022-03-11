package co.integrapps.services.adapters.web;

import co.integrapps.services.adapters.web.dto.ResponseInvoiceToNegotiateDto;
import co.integrapps.services.application.port.in.GetInvoicesToNegotiateUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "invoices controller")
@RequestMapping("/invoices")
@Validated
@CrossOrigin("*")
public class GetInvoiceToNegotiateController {
    @Autowired
    private GetInvoicesToNegotiateUseCase getInvoicesToNegotiateService;

    @Cacheable(value="invoices to negotiate")
    @ApiOperation(
            httpMethod = "GET",
            value = "get all invoices to negotiate",
            response = List.class
    )
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseInvoiceToNegotiateDto getAllInvoices(){

        return new ResponseInvoiceToNegotiateDto(getInvoicesToNegotiateService.getAllInvoices());
    }
}
