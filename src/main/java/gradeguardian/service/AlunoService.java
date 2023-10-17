package gradeguardian.service;

import gradeguardian.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import gradeguardian.model.Aluno;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
@AllArgsConstructor
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    public Aluno createAluno(Aluno aluno){
        return this.alunoRepository.save(aluno);
    }

    public void readByAluno(Long id){
        this.alunoRepository.findById(id);
    }
    public void readAllAluno(){
        this.alunoRepository.findAll();
    }

    public Aluno updateAluno(Aluno aluno){
        return this.alunoRepository.save(aluno);
    }

    public void deleteAluno(Long id){
        Aluno deletar = this.alunoRepository.findById(id).get();
        this.alunoRepository.delete(deletar);
    }


}
