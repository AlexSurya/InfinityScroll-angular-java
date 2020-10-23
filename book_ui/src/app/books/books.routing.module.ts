import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookinfoComponent } from './bookinfo/bookinfo.component';
import { BooksComponent } from './books.component';


const routes: Routes = [
  {
    path: '',
    component: BooksComponent
  },
   {
    path: ':id/info',
    component: BookinfoComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BooksRoutingModule { }
