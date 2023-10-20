package gradeguardian.controller;

import gradeguardian.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import gradeguardian.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping(value = "created")
    public Aluno setAluno(@Validated @RequestBody Aluno aluno){
        return this.alunoService.createAluno(aluno);
    }

    @GetMapping(value = "readAll")
    public void getAllAluno(){
        this.alunoService.readAllAluno();
    }

    @GetMapping(value ="readById/{id}")
    public void getByAluno(@PathVariable Long id){
        this.alunoService.readByAluno(id);
    }

    @PutMapping(value ="update/{id}")
    public Aluno updateAluno(@Validated @RequestBody Aluno aluno){
        return this.alunoService.createAluno(aluno);
    }

    @DeleteMapping(value ="delete/{id}")
    public void deleteByAluno(@PathVariable Long id){
        this.alunoService.deleteAluno(id);
    }


}
