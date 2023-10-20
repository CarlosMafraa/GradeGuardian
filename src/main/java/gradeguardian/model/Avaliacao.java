package gradeguardian.model;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "/avaliacao")

public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private int peso;

    private int id_tipo_avaliacao;

    @Hidden
    @ManyToOne
    @JoinColumn(name = "id_tipo_avaliacao", referencedColumnName = "id")
    private TipoAvaliacao tipoAvaliacao;

    private long notas;

}
