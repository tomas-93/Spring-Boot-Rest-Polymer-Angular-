package com.app.example.core.repository.link;

import com.app.example.core.repository.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tomas Yussef Galicia Guzman
 *         email: tomasyussef@gmail.com
 *         date: 16/09/2016
 */
public interface BookRepository extends JpaRepository<BookEntity, Long>
{
}
