package co.integrapps.services.adapters.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "negotiated_invoices")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true, value = {"idNegInv"})
public class JpaNegotiatedInvoiceEntity implements Serializable {

    @Id
    @Column(name="id_neg_inv")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idNegInv;
    @JsonProperty("invoice_number")
    private String invoiceNumber;
    @JsonProperty("issuer_tax_number")
    private String issuerTaxNumber;
    @JsonProperty("issuer_name")
    private String issuerName;
    @JsonProperty("debtor_tax_number")
    private String debtorTaxNumber;
    @JsonProperty("debtor_name")
    private String debtorName;
    @JsonProperty("assignee_tax_number")
    private String assigneeTaxNumber;
    @JsonProperty("assignee_name")
    private String assigneeName;
    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonProperty("payment_date_with_extension")
    private Date paymentDateWithExtension;
    @JsonProperty("disbursement_date")
    private Date disbursementDate;
    @JsonProperty("total_amount")
    @JsonSerialize(using=CientificNotationMapper.class)
    private Float totalAmount;
    @JsonProperty("discount_total")
    @JsonSerialize(using=CientificNotationMapper.class)
    private Float discountTotal;
    @JsonProperty("value_to_funder")
    @JsonSerialize(using=CientificNotationMapper.class)
    private Float valueToFunder;
    @JsonProperty("bar_code")
    private String barCode;
    private String codehash;
    @JsonProperty("value_margin_debtor")
    @JsonSerialize(using=CientificNotationMapper.class)
    private Float valueMarginDebtor;
    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonProperty("negociation_date")
    private Date negociationDate;
    private String model;
    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonProperty("date")
    @CreationTimestamp
    private Date fechaCrea;
    @JsonProperty("funder_name")
    private String funderName;
    @JsonProperty("funder_tax_number")
    private String funderTaxNumber;
    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonProperty("due_date")
    private Date dueDate;

}