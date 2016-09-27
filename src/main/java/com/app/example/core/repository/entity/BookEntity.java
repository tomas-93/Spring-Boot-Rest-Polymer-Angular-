package com.app.example.core.repository.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Tomas Yussef Galicia Guzman
 *         email: tomasyussef@gmail.com
 *         date: 16/09/2016
 */
@Entity
@Table(name = "book", schema = "biblioteca_spring")
public class BookEntity
{
    private Long idBook;
    private String nameBook;
    private String author;
    private String editorial;
    private LocalDateTime createBook;

    @Id
    @Column(name = "idBook")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIdBook()
    {
        return idBook;
    }

    public void setIdBook(Long idBook)
    {
        this.idBook = idBook;
    }

    @Basic
    @Column(name = "name_book", nullable = false, length = 50)
    public String getNameBook()
    {
        return nameBook;
    }

    public void setNameBook(String nameBook)
    {
        this.nameBook = nameBook;
    }

    @Basic
    @Column(name = "author", nullable = false, length = 50)
    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    @Basic
    @Column(name = "editorial", nullable = false, length = 50)
    public String getEditorial()
    {
        return editorial;
    }

    public void setEditorial(String editorial)
    {
        this.editorial = editorial;
    }

    @Basic
    @Column(name = "create_book", nullable = false)
    public LocalDateTime getCreateBook()
    {
        return createBook;
    }

    public void setCreateBook(LocalDateTime createBook)
    {
        this.createBook = createBook;
    }

}
