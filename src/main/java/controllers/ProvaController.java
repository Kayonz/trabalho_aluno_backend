package controllers;

import models.ProvaModel;
import services.ProvaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin(origins = "*")
public class ProvaController {
    
    @Autowired
    private ProvaService provaService;
    
    @GetMapping
    public ResponseEntity<List<ProvaModel>> listarTodos() {
        List<ProvaModel> alunos = provaService.listarTodos();
        return ResponseEntity.ok(alunos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProvaModel> buscarPorId(@PathVariable Long id) {
        Optional<ProvaModel> aluno = provaService.buscarPorId(id);
        return aluno.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody ProvaModel provaModel, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> 
                errors.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errors);
        }
        
        ProvaModel novoAluno = provaService.salvar(provaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @Valid @RequestBody ProvaModel provaModel, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> 
                errors.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errors);
        }
        
        try {
            ProvaModel alunoAtualizado = provaService.atualizar(id, provaModel);
            return ResponseEntity.ok(alunoAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            provaService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}


