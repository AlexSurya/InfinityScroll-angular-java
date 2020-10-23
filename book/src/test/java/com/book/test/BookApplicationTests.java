package com.book.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.book.repository.BookRepository;
import com.book.service.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

class BookApplicationTests {

	@MockBean
	private BookRepository bookRepository;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void getBooksStatusTest() throws Exception {
		mockMvc.perform(get("/books?page=0&size=10").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void getBooksInvalidPageStatusTest() throws Exception {
		mockMvc.perform(get("/books?page=-1&size=1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError());
	}

	@Test
	void getBooksInvalidSizeStatusTest() throws Exception {
		mockMvc.perform(get("/books?page=-1&size=1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError());
	}

	@Test
	void getBooksByAuthorNotInSelectedBookStatusTest() throws Exception {
		mockMvc.perform(get("/books/alex/author?id=12&page=0&size=10").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void getBooksByAuthorNotInSelectedBookSInvalidPageStatusTest() throws Exception {
		mockMvc.perform(get("/books/alex/author?id=12&page=-1&size=10").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError());
	}

	@Test
	void getBooksByAuthorNotInSelectedBookSInvalidSizeStatusTest() throws Exception {
		mockMvc.perform(get("/books/alex/author?id=12&page=-1&size=10").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError());
	}

	@Test
	void evaluatesBookPageableParameter() throws Exception {

		mockMvc.perform(get("/books").param("page", "1").param("size", "10")).andExpect(status().isOk());

		ArgumentCaptor<PageRequest> pageableCaptor = ArgumentCaptor.forClass(PageRequest.class);
		verify(bookRepository).findAll(pageableCaptor.capture());
		PageRequest pageable = (PageRequest) pageableCaptor.getValue();

		assertThat(pageable.getPageNumber(), is(1));
		assertThat(pageable.getPageSize(), is(10));
		assertThat(pageable.getSort().toString(), is("title: ASC"));
	}

}
