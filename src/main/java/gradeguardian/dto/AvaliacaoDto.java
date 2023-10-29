package gradeguardian.dto;

import gradeguardian.enumeration.Bimestre;
import gradeguardian.enumeration.TipoAvaliacao;
import gradeguardian.model.Nota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoDto {

    private String materia;
    private String nome;
    private int peso;
    private Date date;
    private Bimestre bimestre;
    private TipoAvaliacao tipoAvaliacao;
    private List<Nota> notas;
}
