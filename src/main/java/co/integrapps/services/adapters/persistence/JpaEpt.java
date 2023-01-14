package co.integrapps.services.adapters.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "ept")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JpaEpt {
    @Id
    private Integer idept;
    private Integer ideptdoc;
    private Integer item;
    private Float cantenviada;
    private Float cantubicada;
    private String barcodeh;
    private Integer idbodegadestino;
    @Column(name="Strbodega")
    private String strbodega;
    private String strubicacion;
    private String strlocalizacion;
}
