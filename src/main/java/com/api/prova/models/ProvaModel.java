package com.api.prova.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "alunos")
public class ProvaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, message = "Nome deve ter mais de 2 caracteres")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "Curso é obrigatório")
    @Size(min = 3, message = "Curso deve ter mais de 2 caracteres")
    @Column(nullable = false)
    private String curso;

    @Column
    private String telefone;

    // Construtores
    public ProvaModel() {}

    public ProvaModel(String nome, String curso, String telefone) {
        this.nome = nome;
        this.curso = curso;
        this.telefone = telefone;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

