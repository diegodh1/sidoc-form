package co.integrapps.services.adapters.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "usuario")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JpaUser implements Serializable {
    @Id
    private Integer idusuario;
    private String strusuario;
    private String strpassword;
    private String strnombre;
    private String stremail;
}
