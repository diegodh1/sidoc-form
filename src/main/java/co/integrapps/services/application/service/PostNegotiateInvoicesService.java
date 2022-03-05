package co.integrapps.services.application.service;

import co.integrapps.services.adapters.persistence.JpaNegotiatedInvoiceEntity;
import co.integrapps.services.adapters.persistence.JpaNegotiatedInvoiceRepository;
import co.integrapps.services.adapters.web.dto.ResponseNegotiateInvoiceDto;
import co.integrapps.services.application.port.in.PostNegotiateInvoiceUseCase;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PostNegotiateInvoicesService implements PostNegotiateInvoiceUseCase {
    private final JpaNegotiatedInvoiceRepository negotiatedInvoiceRepository;

    @Override
    public ResponseNegotiateInvoiceDto execute(List<JpaNegotiatedInvoiceEntity> invoices) {
        try {
            invoices.forEach(invoice ->{
                invoice.setDisbursementDate(addOneDay(invoice.getDisbursementDate()));
                invoice.setPaymentDateWithExtension(addOneDay(invoice.getPaymentDateWithExtension()));
                invoice.setNegociationDate(addOneDay(invoice.getNegociationDate()));
            });
            List<JpaNegotiatedInvoiceEntity> result = negotiatedInvoiceRepository.saveAll(invoices);
            return ResponseNegotiateInvoiceDto
                    .builder()
                    .message("invoices negotiated successfully")
                    .payload(result)
                    .build();
        }
        catch (Exception error){
            return ResponseNegotiateInvoiceDto
                    .builder()
                    .error(String.format("error %s cause by %s", error.getMessage(), error))
                    .build();
        }
    }
    public Date addOneDay(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        // convert calendar to date
        return c.getTime();
    }
}
