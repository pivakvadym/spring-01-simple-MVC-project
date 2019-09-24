package com.formation.spring.mvc.controllers;


import com.formation.spring.mvc.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping ("/authors")
    public String getAuthor(Model m){
        m.addAttribute("authors", authorRepository.findAll());
        return "authors";
    }

}
