package gradeguardian.controller;

import gradeguardian.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import gradeguardian.service.AlunoService;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping(value = "created")
    public ResponseEntity<Aluno> createAluno(@Validated @RequestBody Aluno aluno){
        return this.alunoService.createAluno(aluno);
    }

    @GetMapping(value = "readAll")
    public ResponseEntity<List<Aluno>> getAllAluno(){
        return this.alunoService.readAllAluno();
    }

    @GetMapping(value ="readById/{id}")
    public void getByAluno(@PathVariable Long id){
        this.alunoService.readByAluno(id);
    }

    @PutMapping(value ="update/{id}")
    public ResponseEntity<Aluno> updateAluno(@Validated Long id, @RequestBody Aluno aluno){
        return this.alunoService.updateAluno(id,aluno);
    }

    @DeleteMapping(value ="delete/{id}")
    public void deleteByAluno(@PathVariable Long id){
        this.alunoService.deleteAluno(id);
    }


}
