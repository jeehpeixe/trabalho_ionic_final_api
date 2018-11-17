package com.example.demo;

import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jessicapeixe
 */
@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class RestControllerUsuario {
    
    static List<Usuario> usuarios = new ArrayList();
    
    AssemblerUsuario assembler = new AssemblerUsuario();
    
    @PostConstruct
    public void init(){
        usuarios.add(new Usuario("jessica", "jeehpeixe@teste.com", "Jéssica Peixe", "666", "pt-br"));
        usuarios.add(new Usuario("user", "user@teste.com", "User Teste", "abc123", "en-us"));
    }
    
    @ApiOperation("Busca todos os usuarios da lista")
    @GetMapping(produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<ResourceUsuario>> getLista(){
        return new ResponseEntity<>(assembler.toResources(usuarios), HttpStatus.OK);
    }
    
    @ApiOperation("Busca um usuario específico conforme o login informado")
    @GetMapping("/{login}")
    public ResponseEntity<ResourceUsuario> getUsuario(@PathVariable String login){
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                return new ResponseEntity<>(assembler.toResource(usuario), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
    @ApiOperation("Busca um usuario específico conforme o email informado")
    @PostMapping
    public ResponseEntity<ResourceUsuario> getUsuarioFromEmail(@RequestBody Usuario user){
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(user.getEmail())) {
                return new ResponseEntity<>(assembler.toResource(usuario), HttpStatus.OK);
            }
        }
        
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
    @ApiOperation("Busca um usuario pelo login e altera seu nome e idioma")
    @PutMapping("/{login}")
    public ResponseEntity<ResourceUsuario> alteraUsuario(@PathVariable String login, @RequestBody Usuario user){
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                usuario.setNome(user.getNome());
                usuario.setIdioma(user.getIdioma());
                return new ResponseEntity<>(assembler.toResource(usuario), HttpStatus.OK);
            }
        }
        
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }
}