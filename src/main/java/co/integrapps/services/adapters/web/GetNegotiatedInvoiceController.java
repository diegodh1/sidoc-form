package co.integrapps.services.adapters.web;

import co.integrapps.services.adapters.web.dto.CodeHashRequest;
import co.integrapps.services.adapters.web.dto.RequestNegotiateInvoicesDto;
import co.integrapps.services.application.port.in.GetNegotiatedInvoiceUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "negotiated invoices controller")
@RequestMapping("/invoices")
@Validated
@CrossOrigin("*")
public class GetNegotiatedInvoiceController {
    @Autowired
    private GetNegotiatedInvoiceUseCase getNegotiatedInvoiceService;

    @ApiOperation(
            httpMethod = "GET",
            value = "get all the negotiated invoices",
            response = List.class
    )
    @RequestMapping(
            value = "/negotiated",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RequestNegotiateInvoicesDto getAllNegotiatedInvoices(@RequestBody(required=false) CodeHashRequest request){
        if(request != null && !request.getHashCode().equals("")){
            return new RequestNegotiateInvoicesDto(getNegotiatedInvoiceService.getAllByHashCode(request.getHashCode()));
        }
        return new RequestNegotiateInvoicesDto(getNegotiatedInvoiceService.getAllNegotiatedInvoice());
    }

}
