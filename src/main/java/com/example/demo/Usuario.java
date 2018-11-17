package com.example.demo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Usuario implements Serializable {
    
    String login;
    String email;
    String nome;
    String senha;
    String idioma;

    public Usuario() {
        super();
    }

    public Usuario(String login, String email, String nome, String senha, String idioma) {
        this.login = login;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.idioma = idioma;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}