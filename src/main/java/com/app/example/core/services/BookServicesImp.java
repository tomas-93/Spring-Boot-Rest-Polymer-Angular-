package com.app.example.core.services;


import com.app.example.core.dto.BookDto;
import com.app.example.core.repository.entity.BookEntity;
import com.app.example.core.repository.link.BookRepository;
import com.app.example.core.services.link.BookServices;
import com.app.example.core.services.util.Conver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Tomas Yussef Galicia Guzman
 *         email: tomasyussef@gmail.com
 *         date: 09/09/2016
 */
@Service
@Transactional
public class BookServicesImp implements BookServices
{

    private static final Logger logger = LoggerFactory.getLogger(BookServicesImp.class);

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<BookDto> getAllBooks(Pageable pageable)
    {
        return this.bookRepository.findAll(pageable).map(Conver::bookDto);
    }

    @Override
    public BookDto getBook(Long id)
    {
        return Conver.bookDto(this.bookRepository.getOne(id));
    }

    @Override
    public BookDto updateBook(BookDto bookDto)
    {
        return Conver.bookDto(this.bookRepository.save(Conver.bookEntity(bookDto)));
    }

    @Override
    public BookDto saveBook(BookDto bookDto)
    {
        BookEntity newBookEntity = Conver.bookEntity(bookDto);
        return Conver.bookDto(this.bookRepository.save(newBookEntity));
    }

    @Override
    public void deleteBook(Long id)
    {
        this.bookRepository.delete(id);
    }
}
