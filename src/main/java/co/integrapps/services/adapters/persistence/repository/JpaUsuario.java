package co.integrapps.services.adapters.persistence.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "usuario_app")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JpaUsuario implements Serializable {
    @Id
    @Column(name="usuario_id")
    private String userId;
    private String password;
    private String encuestador;
    private String name;
    private Boolean isActive;
    private Boolean isAdmin;
    @CreationTimestamp
    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;
}
