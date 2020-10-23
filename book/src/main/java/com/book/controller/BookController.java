/**
 * 
 */
package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.service.BookService;

/**
 * @author alexsurya
 *
 */
@RestController
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping(path = "books")
	public ResponseEntity<Object> booksPagination(@RequestParam("page") int page, @RequestParam("size") int size) {

		return new ResponseEntity<Object>(bookService.getBooks(page,size), HttpStatus.OK);
	}
	
	@GetMapping(path = "books/{authorname}/author")
	public ResponseEntity<Object> getBooksByAuthorAndDenySelectedBook(@PathVariable String authorname,@RequestParam("id") String id,@RequestParam("page") int page, @RequestParam("size") int size) {

		return new ResponseEntity<Object>(bookService.getByAuthorAndNotSelectedBook(authorname,id, page, size), HttpStatus.OK);
	}
}
