/**
 * 
 */
package com.book.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.book.model.Book;

/**
 * @author alexsurya
 *
 */
public interface BookRepository extends MongoRepository<Book, String> {

	Page<Book> findByAuthor(String author, PageRequest pageRequest);
	
	Page<Book> findByAuthorAndIdNotIn(String author,String id, PageRequest pageRequest);

	
}
