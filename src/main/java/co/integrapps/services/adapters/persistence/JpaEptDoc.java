package co.integrapps.services.adapters.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "eptdoc")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JpaEptDoc {
    @Id
    private Integer ideptdoc;
    private String barcodeh;
}
