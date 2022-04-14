package co.integrapps.services.adapters.persistence.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "usuario")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JpaUsuario {
    @Id
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
