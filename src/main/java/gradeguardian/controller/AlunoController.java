package gradeguardian.controller;

import gradeguardian.model.Aluno;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import gradeguardian.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private AlunoService alunoService;

    @PostMapping
    public Aluno setAluno(@Validated @RequestBody Aluno aluno){
        return this.alunoService.createAluno(aluno);
    }

    @GetMapping
    public void getAllAluno(){
        this.alunoService.readAllAluno();
    }

    @GetMapping("/{id}")
    public void getByAluno(@PathVariable Long id){
        this.alunoService.readByAluno(id);
    }

    @PostMapping
    public Aluno updateAluno(@Validated @RequestBody Aluno aluno){
        return this.alunoService.createAluno(aluno);
    }

    @GetMapping("/{id}")
    public void DeleteByAluno(@PathVariable Long id){
        this.alunoService.deleteAluno(id);
    }


}
