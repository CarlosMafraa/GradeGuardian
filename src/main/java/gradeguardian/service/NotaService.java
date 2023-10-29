package gradeguardian.service;

import gradeguardian.dto.NotaDto;
import gradeguardian.model.Nota;
import gradeguardian.repository.NotaRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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
public class NotaService {

    @Autowired
    public NotaRepository notaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<Nota> createNota(Nota nota){
        this.notaRepository.save(nota);
        return ResponseEntity.ok(nota);
    }

    public ResponseEntity<NotaDto> readByNota(Long id){
        Optional<Nota> nota = this.notaRepository.findById(id);
        if(nota.isPresent()){
            return ResponseEntity.ok(modelMapper.map(nota.get(), NotaDto.class));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<NotaDto>> readAllNota(){
        List<Nota> notas = this.notaRepository.findAll();
        List<NotaDto> notaDtos = notas.stream().map(
                nota ->modelMapper.map(nota, NotaDto.class)).
                collect(Collectors.toList());
        return ResponseEntity.ok(notaDtos);
    }

    public ResponseEntity<Nota> updateNota(Long id, Nota nota){
        try{
            Optional<Nota> existingNota = notaRepository.findById(id);
            if(existingNota.isPresent()){
                Nota notaUpdate = existingNota.get();
                copyNonNullProperties(nota, notaUpdate);
                this.notaRepository.save(notaUpdate);
                return ResponseEntity.ok(notaUpdate);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
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
