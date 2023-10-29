package gradeguardian.dto;

import gradeguardian.model.Nota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDto {

    private String nome;
    private String matricula;
    private List<Nota> notas;
}
