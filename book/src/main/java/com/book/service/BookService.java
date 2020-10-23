/**
 * 
 */
package com.book.service;

import org.springframework.data.domain.Page;

import com.book.model.Book;

/**
 * @author alexsurya
 *
 */
public interface BookService {
	
	Page<Book> getBooks(int page, int size);
	
	Page<Book> getByAuthorAndNotSelectedBook(String author, String id, int page, int size);

}
