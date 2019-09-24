package com.formation.spring.mvc.repositories;

import com.formation.spring.mvc.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {

}