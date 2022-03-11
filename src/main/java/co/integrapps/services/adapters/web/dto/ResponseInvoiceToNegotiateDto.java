package co.integrapps.services.adapters.web.dto;

import co.integrapps.services.adapters.persistence.repository.JpaInvoiceToNegotiateEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseInvoiceToNegotiateDto implements Serializable {
    @JsonProperty("invoices_to_negotiate")
    private List<JpaInvoiceToNegotiateEntity> invoicesToNegotiate;

}
