import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookService } from 'src/app/service/book.service';

@Component({
  selector: 'app-bookinfo',
  templateUrl: './bookinfo.component.html',
  styleUrls: ['./bookinfo.component.css']
})
export class BookinfoComponent implements OnInit {
  bookInfo: any;
  page: number = 0;
  books = [];

  constructor(private router: Router, private service: BookService) { 
    try {
      this.bookInfo = this.router.getCurrentNavigation().extras.state.book;
      this.getBookByAuthor(this.bookInfo, this.page);
      
      
    } catch(error) {
      this.router.navigate(['']);

    }

  }

  ngOnInit() {
  }

  onSuccess(response) {
    response.content.forEach(book => {
      this.books.push(book);
    });
  }

  onScroll() {
    this.page = this.page + 1;
    this.getBookByAuthor(this.bookInfo,this.page);
  }

  getBookByAuthor(book,page) {
    this.service.get("/books/"+book.author+"/author?id="+book.id+"&page=" + page + "&size=10").subscribe((response: any) => {
      this.onSuccess(response);
    });
  }

  rowClick(book) {
    this.bookInfo = book;
    this.books = [];
    this.page = 0;
    this.getBookByAuthor(this.bookInfo,this.page);
  }


}
