package gradeguardian.service;

import gradeguardian.model.Nota;
import gradeguardian.repository.NotaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NotaService {

    @Autowired
    public NotaRepository notaRepository;

    public ResponseEntity<Nota> createNota(Nota nota){
        this.notaRepository.save(nota);
        return ResponseEntity.ok(nota);
    }

    public ResponseEntity<Nota> readByNota(Long id){
        Optional<Nota> nota = this.notaRepository.findById(id);
        if(nota.isEmpty()){
            return ResponseEntity.ok(nota.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<Nota>> readAllNota(){
        List<Nota> notas = this.notaRepository.findAll();
        return ResponseEntity.ok(notas);
    }

    public ResponseEntity<Nota> updateNota(Long id, Nota nota){
        Optional<Nota> existingNota = notaRepository.findById(id);
        if(existingNota.isPresent()){
            this.notaRepository.save(nota);
            return ResponseEntity.ok(nota);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> deleteNota(Long id){
        if(this.notaRepository.existsById(id)){
            this.notaRepository.deleteById(id);
            return ResponseEntity.ok("Nota deletada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nota não encontrada!");
        }
    }
}
