package gradeguardian.service;

import gradeguardian.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import gradeguardian.model.Aluno;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    public ResponseEntity<Aluno> createAluno(Aluno aluno){
        this.alunoRepository.save(aluno);
        return ResponseEntity.ok(aluno);
    }

    public ResponseEntity<Aluno> readByAluno(Long id){
        Optional<Aluno> aluno = this.alunoRepository.findById(id);
        if (aluno.isEmpty()) {
            return ResponseEntity.ok(aluno.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<List<Aluno>> readAllAluno(){
        List<Aluno> alunos = this.alunoRepository.findAll();
        return ResponseEntity.ok(alunos);
    }

    public ResponseEntity<Aluno> updateAluno(Long id, Aluno aluno){
        try{
            Optional<Aluno> existingAluno = alunoRepository.findById(id);
            if(existingAluno.isPresent()){
                Aluno alunoUpdate = existingAluno.get();
                BeanUtils.copyProperties(aluno,alunoUpdate);
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


}
