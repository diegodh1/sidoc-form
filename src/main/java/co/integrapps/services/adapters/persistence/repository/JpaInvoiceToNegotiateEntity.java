package co.integrapps.services.adapters.persistence.repository;

import co.integrapps.services.adapters.persistence.CientificNotationMapper;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "invoices_to_negotiate")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JpaInvoiceToNegotiateEntity implements Serializable {
    @Id
    @JsonProperty("bar_code")
    private String barCode;
    @JsonProperty("issuer_tax_number")
    private String issuerTaxNumber;
    @JsonProperty("issuer_name")
    private String issuerName;
    @JsonProperty("debtor_tax_number")
    private String debtorTaxNumber;
    @JsonProperty("debtor_name")
    private String debtorName;
    @JsonProperty("doc_number")
    private String docNumber;
    @JsonProperty("issue_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date issueDate;
    @JsonProperty("due_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dueDate;
    @JsonProperty("reception_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date receptionDate;
    @JsonProperty("net_amount")
    @JsonSerialize(using= CientificNotationMapper.class)
    private Float netAmount;
    @JsonProperty("tax_amount")
    @JsonSerialize(using=CientificNotationMapper.class)
    private Float taxAmount;
    @JsonProperty("withholding_tax_amount")
    @JsonSerialize(using=CientificNotationMapper.class)
    private Float withholdingTaxAmount;
    private Integer notes;
    @JsonProperty("total_amount")
    @JsonSerialize(using=CientificNotationMapper.class)
    private Float totalAmount;
    private String comments;
    private String status;
    @JsonProperty("payment_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date paymentDate;

}


