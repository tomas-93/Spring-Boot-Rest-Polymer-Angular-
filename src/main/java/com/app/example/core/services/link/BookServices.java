package com.app.example.core.services.link;

import com.app.example.core.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Tomas Yussef Galicia Guzman
 *         email: tomasyussef@gmail.com
 *         date: 09/09/2016
 */
public interface BookServices
{
    Page<BookDto> getAllBooks(Pageable pageable);
    BookDto getBook(Long id);
    BookDto updateBook(BookDto bookDto);
    BookDto saveBook(BookDto bookDto);
    void deleteBook(Long id);
}
