package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author jessicapeixe
 */
@Configuration
public class Configuracao extends WebMvcConfigurerAdapter{

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false).
            favorParameter(true).
            parameterName("mediaType").
            ignoreAcceptHeader(true).
            useJaf(false).
            defaultContentType(MediaType.APPLICATION_JSON).
            mediaType("xml", MediaType.APPLICATION_XML). 
            mediaType("json", MediaType.APPLICATION_JSON);
    }
}
