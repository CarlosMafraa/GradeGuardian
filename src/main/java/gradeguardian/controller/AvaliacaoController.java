package gradeguardian.controller;

import gradeguardian.model.Avaliacao;
import gradeguardian.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @PostMapping(value = "created")
    public ResponseEntity<Avaliacao> setAvaliacao(@Validated @RequestBody Avaliacao avaliacao){
        return this.avaliacaoService.createAvaliacao(avaliacao);
    }

    @GetMapping(value = "readAll")
    public ResponseEntity<List<Avaliacao>> getAllAvaliacao(){
        return this.avaliacaoService.readAllAvaliacao();
    }

    @GetMapping(value ="readById/{id}")
    public void getByAvaliacao(@PathVariable Long id){
        this.avaliacaoService.readByAvaliacao(id);
    }


    @PutMapping(value ="update/{id}")
    public ResponseEntity<Avaliacao> updateAvaliacao(@PathVariable Long id, @Validated @RequestBody Avaliacao avaliacao){
        return this.avaliacaoService.updateAvaliacao(id,avaliacao);
    }


    @DeleteMapping(value ="delete/{id}")
    public void deletByAvaliacao(@PathVariable Long id){
        this.avaliacaoService.deleteAvaliacao(id);
    }

}
