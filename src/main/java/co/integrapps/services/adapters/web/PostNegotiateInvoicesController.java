package co.integrapps.services.adapters.web;

import co.integrapps.services.adapters.web.dto.RequestNegotiateInvoicesDto;
import co.integrapps.services.adapters.web.dto.ResponseNegotiateInvoiceDto;
import co.integrapps.services.application.port.in.PostNegotiateInvoiceUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "invoices to negotiate controller")
@RequestMapping("/invoices")
@Validated
@CrossOrigin("*")
public class PostNegotiateInvoicesController {
    @Autowired
    private PostNegotiateInvoiceUseCase postNegotiateInvoiceService;

    @ApiOperation(
            httpMethod = "POST",
            value = "send invoices to negotiate",
            response = ResponseNegotiateInvoiceDto.class
    )
    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseNegotiateInvoiceDto sendInvoicesToNegotiate(@RequestBody RequestNegotiateInvoicesDto body){
        return postNegotiateInvoiceService.execute(body.getNegotiatedInvoices());
    }
}
