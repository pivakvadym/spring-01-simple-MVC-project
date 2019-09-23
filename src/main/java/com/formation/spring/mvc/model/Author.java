package com.formation.spring.mvc.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Author {
    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String fisrName;
    private String lastName;

    @ManyToMany
    private Set <Book> books = new HashSet<>() ;


    public Author() {
    }

    public Author(String fisrName, String lastName) {
        this.fisrName = fisrName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFisrName() {
        return fisrName;
    }

    public void setFisrName(String fisrName) {
        this.fisrName = fisrName;
    }



    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(fisrName, author.fisrName) &&
                Objects.equals(lastName, author.lastName) &&
                Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fisrName, lastName, books);
    }
}
