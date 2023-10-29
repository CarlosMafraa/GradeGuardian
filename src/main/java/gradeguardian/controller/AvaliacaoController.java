package gradeguardian.controller;

import gradeguardian.dto.AvaliacaoDto;
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

    @PostMapping
    public ResponseEntity<Avaliacao> setAvaliacao(@Validated @RequestBody Avaliacao avaliacao){
        return this.avaliacaoService.createAvaliacao(avaliacao);
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoDto>> getAllAvaliacao(){
        return this.avaliacaoService.readAllAvaliacao();
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<AvaliacaoDto> getByAvaliacao(@PathVariable Long id){
        return this.avaliacaoService.readByAvaliacao(id);
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<Avaliacao> updateAvaliacao(@PathVariable Long id,@RequestBody Avaliacao avaliacao){
        return this.avaliacaoService.updateAvaliacao(id,avaliacao);
    }

    @DeleteMapping(value ="delete/{id}")
    public ResponseEntity<String> deletByAvaliacao(@PathVariable Long id){
        return this.avaliacaoService.deleteAvaliacao(id);
    }

}
