package co.integrapps.services.adapters.persistence.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "encuesta_satisfaccion_proveedor")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JpaEncuestaProveedor implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String proveedor;
    private String marcaProveedor;
    private Double volumenCompra;
    private Double volumenVenta;
    private Double precioCompra;
    private Double precioVenta;
    private String comentarios;
    private String modalidadEntrega;
    @ManyToOne
    private JpaEncuestaSatisfaccion encuesta;
}
