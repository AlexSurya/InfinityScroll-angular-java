/**
 * 
 */
package com.book.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author alexsurya
 *
 */
@Document(collection = "book")
public class Book {

	@Id
	private String id;

	private String title;

	private String author;

	private Double price;

	private float rating;

	private String description;

	private String imageUrl;

	public Book() {
		super();
	}

	public Book(String id, String title, String author, Double price, float rating, String description,
			String imageUrl) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.rating = rating;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", rating=" + rating
				+ ", description=" + description + ", imageUrl=" + imageUrl + "]";
	}

	
	
}
