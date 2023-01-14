package co.integrapps.services.adapters.persistence;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Entity(name = "dtudetalle")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JpaDtuDetalle {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer iddetdtu;
    @Column(name="detdtu_iddoc")
    private Integer detDtuIdDoc;
    @Column(name="detdtu_item")
    private Integer detDtuItem;
    @Column(name="detdtu_estante")
    private String detDtuEstante;
    @Column(name="detdtu_cant")
    private Integer detDtuCant;
    @Column(name="detdtu_canasta")
    private String detDtuCanasta;
    @Column(name="detdtu_ubica")
    private String detDtuUbica;
}
