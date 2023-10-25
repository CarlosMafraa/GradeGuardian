package gradeguardian.service;

import gradeguardian.model.Nota;
import gradeguardian.repository.NotaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotaService {

    @Autowired
    public NotaRepository notaRepository;

    public Nota createNota(Nota nota){
        return this.notaRepository.save(nota);
    }
}
