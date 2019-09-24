package com.formation.spring.mvc.repositories;

import com.formation.spring.mvc.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository <Author,Long> {

}
