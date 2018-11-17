package com.example.demo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

/**
 *
 * @author jessicapeixe
 */
@XmlRootElement
@XmlSeeAlso({Usuario.class})
class ResourceUsuario extends Resource<Usuario>{
    
    public ResourceUsuario() {
        this(new Usuario());
    }
    
    public ResourceUsuario(Usuario usuario, Link... links) {
        super(usuario, links);
    }
}
