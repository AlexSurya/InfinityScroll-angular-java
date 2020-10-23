import { NgModule } from '@angular/core';

import { BooksRoutingModule } from './books.routing.module';
import { BooksComponent } from './books.component';
import { InfiniteScrollModule } from 'ngx-infinite-scroll';
import { CommonModule } from '@angular/common';
import { MatButtonModule, MatCardModule, MatMenuModule, MatToolbarModule } from '@angular/material';
import { BookinfoComponent } from './bookinfo/bookinfo.component';

@NgModule({
  declarations: [
    BooksComponent,
    BookinfoComponent
  ],
  imports: [
    CommonModule,
    BooksRoutingModule,
    InfiniteScrollModule,
    MatCardModule,
    MatToolbarModule,
    MatButtonModule,
    MatMenuModule,
  ]
})
export class BooksModule { }
