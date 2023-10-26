package gradeguardian.model;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nota")
public class Nota {

    @Hidden
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valor;

    @ManyToOne
    @JoinColumn(name = "avaliacao_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Avaliacao avaliacao;

    @ManyToOne
    @JoinColumn(name = "aluno_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Aluno aluno;




}
