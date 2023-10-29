package gradeguardian.service;

import gradeguardian.dto.AvaliacaoDto;
import gradeguardian.model.Avaliacao;
import gradeguardian.repository.AvaliacaoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static gradeguardian.config.CopyNonNullProperties.copyNonNullProperties;

@Service
@AllArgsConstructor
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<Avaliacao> createAvaliacao(Avaliacao avaliacao){
        this.avaliacaoRepository.save(avaliacao);
        return ResponseEntity.ok(avaliacao);
    }

    public ResponseEntity<AvaliacaoDto> readByAvaliacao(Long id){
        Optional<Avaliacao> avaliacao = this.avaliacaoRepository.findById(id);
        if(avaliacao.isPresent()){
            return ResponseEntity.ok(modelMapper.map(avaliacao.get(),AvaliacaoDto.class));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<AvaliacaoDto>> readAllAvaliacao(){
        List<Avaliacao> avaliacaos = this.avaliacaoRepository.findAll();
        List<AvaliacaoDto> avaliacaoDtos = avaliacaos.stream().map(
                avaliacao -> modelMapper.map(avaliacao, AvaliacaoDto.class)).
                collect(Collectors.toList());
        return ResponseEntity.ok(avaliacaoDtos);
    }

    public ResponseEntity<Avaliacao> updateAvaliacao(Long id,Avaliacao avaliacao){
        try{
            Optional<Avaliacao> existingAvaliacao = avaliacaoRepository.findById(id);
            if(existingAvaliacao.isPresent()){
                Avaliacao avaliacaoUpdate = existingAvaliacao.get();
                copyNonNullProperties(avaliacao, avaliacaoUpdate);
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
