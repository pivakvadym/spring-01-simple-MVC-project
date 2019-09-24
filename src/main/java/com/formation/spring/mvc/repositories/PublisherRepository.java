package com.formation.spring.mvc.repositories;

import com.formation.spring.mvc.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {

}