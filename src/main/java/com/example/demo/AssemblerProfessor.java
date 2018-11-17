package com.example.demo;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 *
 * @author jessicapeixe
 */
public class AssemblerProfessor extends ResourceAssemblerSupport<Professor, ResourceProfessor>{

    public AssemblerProfessor() {
        super(Professor.class, ResourceProfessor.class);
    }

    @Override
    public ResourceProfessor toResource(Professor professor) {
        return new ResourceProfessor(
            professor
            //, 
            //linkTo(methodOn(RestControllerProfessor.class).getProfessor(professor.getId())).withSelfRel()
        );
    }
    

    @Override
    protected ResourceProfessor instantiateResource(Professor professor) {
        return new ResourceProfessor(professor);
    }    
}