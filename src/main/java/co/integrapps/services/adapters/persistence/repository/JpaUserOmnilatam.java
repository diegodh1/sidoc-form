package co.integrapps.services.adapters.persistence.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "app_user_omnilatam")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JpaUserOmnilatam implements Serializable {
    @Id
    private String username;
    private String passwrd;
    @Column(name="is_active")
    private Boolean isActive;
    @Column(name="created_at")
    private Date created_at;
}
