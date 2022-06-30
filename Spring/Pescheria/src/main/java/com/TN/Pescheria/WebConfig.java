package com.TN.Pescheria;

import org.springframework.context.annotation.Configuration; 
import org.springframework.context.annotation.Profile; 
import org.springframework.web.servlet.config.annotation.CorsRegistry; 
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; 

@Profile("dev") 
@Configuration 
public class WebConfig implements WebMvcConfigurer { 
 
    @Override 
    public void addCorsMappings(CorsRegistry registry) { 
        registry.addMapping("/**");
           
       } 
}
