import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { AppComponent } from '../app.component';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  books: any[] = []; 
  books2: any[] = []; 
  search:string="";
  selected:string="Title";
  constructor(private dataService: DataService,private appComponent:AppComponent) {
   }
   
   onCarSelection(){
console.log(this.selected, this.search);

if(this.selected=="Title"){
  this.books = this.books2.filter(item => item.title.toLowerCase().includes(this.search.toLowerCase()));
}else if(this.selected=="Author") {
this.books = this.books2.filter(item => item.author.toLowerCase().includes(this.search.toLowerCase()));
}else{
  this.books = this.books2.filter(item => item.genre.toLowerCase().includes(this.search.toLowerCase()));
}

   }

  ngOnInit(): void {
    this.loadBooks();
    this.appComponent.ngOnInit();
  }

  loadBooks() {
    this.dataService.getAllBooks().subscribe((data: any) => {
      this.books = data; 
      this.books2= data; 
      this.dataService.setArr(this.books);
    });
  }
}
