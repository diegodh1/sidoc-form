package co.integrapps.services.adapters.web.dto;

import co.integrapps.services.adapters.persistence.JpaNegotiatedInvoiceEntity;
import co.integrapps.services.adapters.persistence.JpaNegotiatedInvoiceRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestNegotiateInvoicesDto implements Serializable {
    @JsonProperty("negotiated_invoices")
    private List<JpaNegotiatedInvoiceEntity> negotiatedInvoices;
}
