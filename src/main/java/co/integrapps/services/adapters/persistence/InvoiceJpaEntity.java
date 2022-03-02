package co.integrapps.services.adapters.persistence;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity(name = "invoices_to_negotiate")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvoiceJpaEntity implements Serializable {
    @Id
    private String barCode;
    private String issuerTaxNumber;
    private String issuerName;
    private String debtorTaxNumber;
    private String debtorName;
    private String docNumber;
    private Date issueDate;
    private Date dueDate;
    private Date receptionDate;
    private Float netAmount;
    private Float taxAmount;
    private Float withholdingTaxAmount;
    private Integer notes;
    private Float totalAmount;
    private String comments;
    private String status;
    private Date paymentDate;

}


