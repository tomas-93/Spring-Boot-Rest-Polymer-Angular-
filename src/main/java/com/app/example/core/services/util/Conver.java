package com.app.example.core.services.util;


import com.app.example.core.dto.*;
import com.app.example.core.repository.entity.*;
import org.springframework.beans.BeanUtils;


/**
 * @author Tomas Yussef Galicia Guzman
 *         email: tomasyussef@gmail.com
 *         date: 10/09/2016
 */
public class Conver
{
    public static BookEntity bookEntity(BookDto bookDto)
    {
        BookEntity bookEntity = new BookEntity();
        BeanUtils.copyProperties(bookDto, bookEntity);
        return bookEntity;
    }

    public static BookDto bookDto(BookEntity bookEntity)
    {
        BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(bookEntity, bookDto);
        return bookDto;
    }
}
