package com.example.demo;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 *
 * @author jessicapeixe
 */
public class AssemblerUsuario extends ResourceAssemblerSupport<Usuario, ResourceUsuario>{

    public AssemblerUsuario() {
        super(Usuario.class, ResourceUsuario.class);
    }

    @Override
    public ResourceUsuario toResource(Usuario usuario) {
        return new ResourceUsuario(
            usuario
            //, 
            //linkTo(methodOn(RestControllerUsuario.class).getUsuario(usuario.getLogin())).withSelfRel()
        );
    }
    

    @Override
    protected ResourceUsuario instantiateResource(Usuario usuario) {
        return new ResourceUsuario(usuario);
    }    
}