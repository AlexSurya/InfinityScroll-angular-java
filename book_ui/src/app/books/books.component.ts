import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookService } from '../service/book.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent {

  page: number = 0;
  books = [];

  constructor(private service: BookService, private router: Router) { }
  ngOnInit() {

    this.getBooks(this.page);
    // this.getPhotos();
  }

  onSuccess(response) {
    response.content.forEach(book => {
      this.books.push(book);
    });
  }

  onScroll() {
    this.page = this.page + 1;
    this.getBooks(this.page);
  }

  getBooks(page) {
    this.service.get("/books?page=" + page + "&size=10").subscribe((response: any) => {
      this.onSuccess(response);
    });
  }

  rowClick(book) {
    this.router.navigate([book.id+"/info"],({ state: { "book": book} }));
  }

}