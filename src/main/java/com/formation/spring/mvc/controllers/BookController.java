package com.formation.spring.mvc.controllers;


import com.formation.spring.mvc.model.Book;
import com.formation.spring.mvc.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private  BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping ("/books")
    public String getBook(Model m){
        m.addAttribute("books",bookRepository.findAll());
        return "books";
    }

}
