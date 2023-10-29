package gradeguardian.controller;

import gradeguardian.dto.NotaDto;
import gradeguardian.model.Nota;
import gradeguardian.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nota")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @PostMapping
    public ResponseEntity<Nota> createNota(@Validated @RequestBody Nota nota){
        return this.notaService.createNota(nota);
    }

    @GetMapping
    public ResponseEntity<List<NotaDto>> getAllNota(){
        return this.notaService.readAllNota();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<NotaDto> getNotaById(@PathVariable Long id){
        return this.notaService.readByNota(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Nota> updatedNota(@Validated @PathVariable Long id ,@RequestBody Nota nota){
        return this.notaService.updateNota(id, nota);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteNota(@PathVariable Long id){
        return this.notaService.deleteNota(id);
    }
}
