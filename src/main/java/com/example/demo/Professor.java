package com.example.demo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Professor implements Serializable {
    
    Long id;    
    String nome;
    String nascimento;
    String foto;
    String curriculo;
    Boolean status;

    public Professor() {
        super();
    }
    
    public Professor(Long id, String nome, String nascimento, String foto, String curriculo, Boolean status) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.foto = foto;
        this.curriculo = curriculo;
        this.status = status;
    }

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

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}