package gradeguardian.service;

import gradeguardian.model.Avaliacao;
import gradeguardian.repository.AvaliacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public Avaliacao createAvaliacao(Avaliacao avaliacao){
        return this.avaliacaoRepository.save(avaliacao);
    }

    public void readByAvaliacao(Long id){
        this.avaliacaoRepository.findById(id);
    }

    public List<Avaliacao> readAllAvaliacao(){
        return this.avaliacaoRepository.findAll();
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

    public void deleteAvaliacao(Long id){
        this.avaliacaoRepository.deleteById(id);
    }


}
