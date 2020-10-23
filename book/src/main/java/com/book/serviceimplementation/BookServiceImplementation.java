/**
 * 
 */
package com.book.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.book.model.Book;
import com.book.repository.BookRepository;
import com.book.service.BookService;

/**
 * @author alexsurya
 *
 */
@Service
public class BookServiceImplementation implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public Page<Book> getBooks(int page, int size) {
		return bookRepository.findAll(PageRequest.of(page, size, Sort.by(Order.asc("title"))));

	}

	@Override
	public Page<Book> getByAuthorAndNotSelectedBook(String author,String id, int page, int size) {
		return bookRepository.findByAuthorAndIdNotIn(author, id, PageRequest.of(page, size, Sort.by(Order.asc("title"))));	}

}
