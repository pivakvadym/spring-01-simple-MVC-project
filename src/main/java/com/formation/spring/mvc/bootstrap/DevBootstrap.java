package com.formation.spring.mvc.bootstrap;

import com.formation.spring.mvc.model.Author;
import com.formation.spring.mvc.model.Book;
import com.formation.spring.mvc.model.Publisher;
import com.formation.spring.mvc.repositories.AuthorRepository;
import com.formation.spring.mvc.repositories.BookRepository;
import com.formation.spring.mvc.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;

    }

    private void initData(){

        Author author1 =  new Author("Fiodor", "Dostoevky");
        Book book1 =  new Book("My Book","publisherA");
        book1.getAuthors().add(author1);

        Author author2 =  new Author("Noham", "Shomsky");
        Book book2 =  new Book("My Book","publisherA");
        book2.getAuthors().add(author2);

        Publisher publisher1 = new Publisher("publisher1","address_publisher1");
        Publisher publisher2 = new Publisher("publisher2","address_publisher2");

        publisherRepository.save(publisher1);
        publisherRepository.save(publisher2);


        book1.setPublisher(publisher1);
        book2.setPublisher(publisher2);

        authorRepository.save(author1);
        authorRepository.save(author2);

        bookRepository.save(book1);
        bookRepository.save(book2);

     }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
