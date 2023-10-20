package gradeguardian.model;

import gradeguardian.enumeration.TipoAvaliacao;
import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "/avaliacao")

public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int peso;
    private Date date;

    @Enumerated(EnumType.STRING)
    private TipoAvaliacao tipoAvaliacao;

    private Double notas;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

}
