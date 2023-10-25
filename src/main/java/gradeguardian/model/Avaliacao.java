package gradeguardian.model;

import gradeguardian.enumeration.TipoAvaliacao;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "/avaliacao")

public class Avaliacao {

    @Hidden
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int peso;
    private Date date;

    @Enumerated(EnumType.STRING)
    private TipoAvaliacao tipoAvaliacao;

    @OneToMany(mappedBy = "avaliacao")
    private List<Nota> notas;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

}
