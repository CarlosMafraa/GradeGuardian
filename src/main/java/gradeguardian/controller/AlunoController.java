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

    @PostMapping
    public ResponseEntity<Aluno> createAluno(@Validated @RequestBody Aluno aluno){
        return this.alunoService.createAluno(aluno);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAllAluno(){
        return this.alunoService.readAllAluno();
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Aluno> getByAluno(@PathVariable Long id){
        return this.alunoService.readByAluno(id);
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody Aluno aluno){
        return this.alunoService.updateAluno(id,aluno);
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<String> deleteByAluno(@PathVariable Long id){
        return this.alunoService.deleteAluno(id);
    }


}
