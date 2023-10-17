package gradeguardian.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "/bimestre")

public class Bimestre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int bimestre;

    @OneToMany
    private List<Avaliacao> avaliacaos;

}
