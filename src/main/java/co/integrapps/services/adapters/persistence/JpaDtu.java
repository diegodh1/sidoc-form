package co.integrapps.services.adapters.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "dtudoc")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JpaDtu {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer iddtu;
    private String dtubarcode;
    private String dtuusu;
    private Date dtufechacrea;
    private Date dtumodifica;
    private Integer dtuestado;
    private String dtubodorigen;
    private Integer ideptdoc;
}
