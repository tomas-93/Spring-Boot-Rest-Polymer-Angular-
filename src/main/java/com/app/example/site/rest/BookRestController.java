package com.app.example.site.rest;

import com.app.example.core.dto.BookDto;
import com.app.example.core.services.link.BookServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Tomas Yussef Galicia Guzman
 *         email: tomasyussef@gmail.com
 *         date: 11/09/2016
 */
@RestController
@RequestMapping("/rest/book")
public class BookRestController
{
    private static final Logger logger = LoggerFactory.getLogger(BookRestController.class);

    private final BookServices bookServices;

    @Autowired
    public BookRestController(BookServices bookServices)
    {
        this.bookServices = bookServices;
    }

    @PostMapping(value = "", produces = "application/json", consumes = "application/json")
    public ResponseEntity<BookDto> postBook(@RequestBody @Validated BookDto bookDto)
    {
        BookDto bookDto1 = this.bookServices.saveBook(bookDto);
        HttpHeaders head = new HttpHeaders();
        head.add("Add Status", HttpStatus.OK + "- Ok");
        return new ResponseEntity<>(bookDto1, head, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<BookDto> patchBook(@PathVariable(value = "id") @NotNull @Min(0) @Validated Long id,
                                             @RequestBody @Validated BookDto bookDto)
    {
        bookDto.setIdBook(id);
        BookDto bookDto1 = this.bookServices.updateBook(bookDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Put-Patch Status", HttpStatus.OK + " - Ok");
        return new ResponseEntity<>(bookDto1, httpHeaders, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable(value = "id") @NotNull @Min(0) @Validated Long id)
    {
        logger.info(String.valueOf(id));
        this.bookServices.deleteBook(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Delete Status", HttpStatus.OK + " - Ok");
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<BookDto> getBook(@NotNull @Min(0) @Validated @PathVariable("id") Long id)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Get View", HttpStatus.OK + " - OK");
        return new ResponseEntity<BookDto>(this.bookServices.getBook(id), httpHeaders, HttpStatus.OK);
    }

    @GetMapping(value = {"/{number}/{size}"}, produces = "application/json")
    public ResponseEntity<Page<BookDto>> getBook(@PathVariable("number") int number,
                                                 @PathVariable("size") int size)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Status", HttpStatus.OK.toString() + " - Ok");
        return new ResponseEntity<>(
                this.bookServices.getAllBooks(new PageRequest(number, size)), headers, HttpStatus.OK
        );
    }
}
