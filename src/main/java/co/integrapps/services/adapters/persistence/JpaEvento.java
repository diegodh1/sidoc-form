package co.integrapps.services.adapters.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Entity(name = "eventos_erp")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JpaEvento {
    @Id
    @Column(name = "id_evento")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "evento_tipo")
    private String tipoEvento;
    @Column(name = "evento_param1")
    private String dtuDocId;
    @Column(name = "evento_param2")
    private String fecha;
    @Column(name = "evento_param3")
    private String username;
}
