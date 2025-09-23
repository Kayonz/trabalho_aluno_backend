package dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProvaDtos {
    
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, message = "Nome deve ter mais de 2 caracteres")
    private String nome;
    
    @NotBlank(message = "Curso é obrigatório")
    @Size(min = 3, message = "Curso deve ter mais de 2 caracteres")
    private String curso;
    
    private String telefone;
    
    // Construtores
    public ProvaDtos() {}
    
    public ProvaDtos(String nome, String curso, String telefone) {
        this.nome = nome;
        this.curso = curso;
        this.telefone = telefone;
    }
    
    // Getters e Setters
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCurso() {
        return curso;
    }
    
    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

