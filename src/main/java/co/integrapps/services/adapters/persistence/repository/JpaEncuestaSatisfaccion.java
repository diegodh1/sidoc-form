package co.integrapps.services.adapters.persistence.repository;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity(name = "encuesta_satisfaccion")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JpaEncuestaSatisfaccion implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer encuestaId;
    private String encuestador;
    @CreationTimestamp
    @Column(updatable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fecha;
    private String barrido;
    private String microzona;
    private String nombre;
    private String departamento;
    private String ciudad;
    private String barrio;
    private String direccion;
    private String contacto;
    private String telefono;
    private Double latitud;
    private Double longitud;
    private Boolean vendeCemento;
    private Boolean fachadaCsm;
    private Boolean virgen;
    private Boolean panaflex;
    @OneToMany(mappedBy="encuesta")
    private Set<JpaEncuestaProveedor> proveedores;
}
