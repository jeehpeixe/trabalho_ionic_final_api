package com.example.demo;

import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin
@RequestMapping("/professores")
public class RestControllerProfessor {
    
    static List<Professor> professores = new ArrayList();
    
    AssemblerProfessor assembler = new AssemblerProfessor();
    
    @PostConstruct
    public void init(){
        long i = 1;
        while(i <= 50){
            professores.add(getProfInit(i));
            i++;
        }
    }
    
    private Professor getProfInit(long codigo){
        return new Professor(codigo, "Professor "+codigo, "2011-11-11T03:00:00.000Z", "", "aaaaaa", true);
    }
    
    @ApiOperation("Busca todos os professores da lista")
    @GetMapping(produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<ResourceProfessor>> getLista(){
        return new ResponseEntity<>(assembler.toResources(professores), HttpStatus.OK);
    }
    
    @GetMapping(value = "/prof_paginado/{page}")
    public ResponseEntity<List<ResourceProfessor>> getListaPaginada(@PathVariable int page){
        int inicio = 10 * (page - 1);
        int fim    = 10 * page;
        int pos    = 0;
        
        List<Professor> profPaginado = new ArrayList();
        
        for (Professor professor : professores) {
            if (pos >= inicio && pos < fim) {
                profPaginado.add(professor);
            }
            if (pos > fim) {
                break;
            }
            pos++;
        }
        
        return new ResponseEntity<>(assembler.toResources(profPaginado), HttpStatus.OK);
    }
   
    @ApiOperation("Busca um professor específico conforme o ID informado")
    @GetMapping("/{id}")
    public ResponseEntity<ResourceProfessor> getProfessor(@PathVariable Long id){
        for (Professor professor : professores) {
            if (professor.getId().equals(id)) {
                return new ResponseEntity<>(assembler.toResource(professor), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
    @ApiOperation("Cria um novo professor e o adiciona na lista")
    @PostMapping
    public ResponseEntity<ResourceProfessor> criaProfessor(@RequestBody Professor professor){
        professor.setId(professores.size() + 1l);
        professores.add(professor);
        return new ResponseEntity<>(assembler.toResource(professor), HttpStatus.OK);
    }
    
    @ApiOperation("Altera os dados do professor relacionado ao ID informado")
    @PutMapping("/{id}")
    public ResponseEntity<ResourceProfessor> alteraProfessor(@PathVariable Long id, @RequestBody Professor professorNovo){
        for (Professor professor : professores) {
            if (professor.getId().equals(id)) {
                professores.remove(professor);
                professores.add(professorNovo);
                return new ResponseEntity<>(assembler.toResource(professorNovo), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ApiOperation("Deleta o professor relacionado ao ID informado")
    @DeleteMapping("/{id}")
    public ResponseEntity<ResourceProfessor> excluiProfessor(@PathVariable Long id){
        for (Professor professor : professores) {
            if (professor.getId().equals(id)) {
                professores.remove(professor);
                return new ResponseEntity<>(assembler.toResource(professor), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }
}