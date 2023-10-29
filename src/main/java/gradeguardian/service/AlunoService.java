package gradeguardian.service;

import gradeguardian.dto.AlunoDto;
import gradeguardian.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import gradeguardian.model.Aluno;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static gradeguardian.config.CopyNonNullProperties.copyNonNullProperties;


@Service
@AllArgsConstructor
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ModelMapper modelMapper;
    public ResponseEntity<Aluno> createAluno(Aluno aluno){
        this.alunoRepository.save(aluno);
        return ResponseEntity.ok(aluno);
    }

    public ResponseEntity<AlunoDto> readByAluno(Long id){
        Optional<Aluno> aluno = this.alunoRepository.findById(id);
        if (aluno.isPresent()) {
            return ResponseEntity.ok(modelMapper.map(aluno.get(), AlunoDto.class));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<List<AlunoDto>> readAllAluno(){
        List<Aluno> alunos = this.alunoRepository.findAll();
        List<AlunoDto> alunoDtos = alunos.stream().map(
                aluno -> modelMapper.map(aluno, AlunoDto.class)).
                collect(Collectors.toList());
        return ResponseEntity.ok(alunoDtos);
    }

    public ResponseEntity<Aluno> updateAluno(Long id, Aluno aluno){
        try{
            Optional<Aluno> existingAluno = alunoRepository.findById(id);
            if(existingAluno.isPresent()){
                Aluno alunoUpdate = existingAluno.get();
                copyNonNullProperties(aluno, alunoUpdate);
                this.alunoRepository.save(alunoUpdate);
                return ResponseEntity.ok(alunoUpdate);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<String> deleteAluno(Long id){
        if(this.alunoRepository.existsById(id)){
            this.alunoRepository.deleteById(id);
            return ResponseEntity.ok("Aluno deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado!");
        }
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
