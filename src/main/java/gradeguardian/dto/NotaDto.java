package gradeguardian.dto;

import gradeguardian.model.Aluno;
import gradeguardian.model.Avaliacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaDto {

    private double valor;
    private Avaliacao avaliacao;
    private Aluno aluno;

}
