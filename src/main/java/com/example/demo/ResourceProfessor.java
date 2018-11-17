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
@XmlSeeAlso({Professor.class})
class ResourceProfessor extends Resource<Professor>{
    
    public ResourceProfessor() {
        this(new Professor());
    }
    
    public ResourceProfessor(Professor professor, Link... links) {
        super(professor, links);
    }
}
