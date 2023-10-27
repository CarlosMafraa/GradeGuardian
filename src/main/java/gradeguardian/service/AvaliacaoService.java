package gradeguardian.service;

import gradeguardian.model.Avaliacao;
import gradeguardian.repository.AvaliacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public ResponseEntity<Avaliacao> createAvaliacao(Avaliacao avaliacao){
        this.avaliacaoRepository.save(avaliacao);
        return ResponseEntity.ok(avaliacao);
    }

    public ResponseEntity<Avaliacao> readByAvaliacao(Long id){
        Optional<Avaliacao> avaliacao = this.avaliacaoRepository.findById(id);
        if(avaliacao.isEmpty()){
            return ResponseEntity.ok(avaliacao.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<Avaliacao>> readAllAvaliacao(){
        List<Avaliacao> avaliacaos = this.avaliacaoRepository.findAll();
        return ResponseEntity.ok(avaliacaos);
    }

    public ResponseEntity<Avaliacao> updateAvaliacao(Long id,Avaliacao avaliacao){
        try{
            Optional<Avaliacao> existingAvaliacao = avaliacaoRepository.findById(id);
            if(existingAvaliacao.isPresent()){
                Avaliacao avaliacaoUpdate = existingAvaliacao.get();
                BeanUtils.copyProperties(avaliacao, avaliacaoUpdate);
                this.avaliacaoRepository.save(avaliacaoUpdate);
                return ResponseEntity.ok(avaliacaoUpdate);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<String> deleteAvaliacao(Long id){
        if(this.avaliacaoRepository.existsById(id)){
            this.avaliacaoRepository.deleteById(id);
            return ResponseEntity.ok("Avaliação deletada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Avaliação não encontrada!");
        }
    }
}
