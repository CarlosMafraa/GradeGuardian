package gradeguardian.model;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "/tipo_avaliacao")
public class TipoAvaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tipo;

    @Hidden
    @OneToMany(mappedBy = "tipo_avaliacao")
    private List<Avaliacao> avaliacaos;
}
