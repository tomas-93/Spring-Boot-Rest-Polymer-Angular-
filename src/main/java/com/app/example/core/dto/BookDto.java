package com.app.example.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 * @author Tomas Yussef Galicia Guzman
 *         email: tomasyussef@gmail.com
 *         date: 13/09/2016
 */
public class BookDto
{
    private Long idBook;
    private String nameBook;
    private String author;
    private String editorial;
    private LocalDateTime createBook;

    @JsonProperty(value = "id_book")
    public Long getIdBook()
    {
        return idBook;
    }

    public void setIdBook(Long idBook)
    {
        this.idBook = idBook;
    }

    @JsonProperty(value = "book_name")
    public String getNameBook()
    {
        return nameBook;
    }

    public void setNameBook(String nameBook)
    {
        this.nameBook = nameBook;
    }

    @JsonProperty(value = "book_author")
    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    @JsonProperty(value = "book_editorial")
    public String getEditorial()
    {
        return editorial;
    }

    public void setEditorial(String editorial)
    {
        this.editorial = editorial;
    }

    @JsonProperty(value = "date_create")
    public LocalDateTime getCreateBook()
    {
        return createBook;
    }

    public void setCreateBook(LocalDateTime createBook)
    {
        this.createBook = createBook;
    }

}
