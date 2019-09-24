package com.formation.spring.mvc.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Author {

    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToMany (mappedBy = "authors")
    private Set <Book> books = new HashSet<>() ;


    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFisrName(String fisrName) {
        this.firstName = fisrName;
    }



    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(firstName, author.firstName) &&
                Objects.equals(lastName, author.lastName) &&
                Objects.equals(books, author.books);
    }

    public Set<Book> getBooks() {
        return books;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, books);
    }
}
