import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataService } from '../data.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-display-books',
  templateUrl: './display-books.component.html',
  styleUrls: ['./display-books.component.css']
})
export class DisplayBooksComponent implements OnInit{
  bookId=0;
  title:string="";
  image:string="";
  author:string="";
  genre:string="";
  description:string="";
  price:number=0;
  review="";
  reviewArr:any[]=[];
  feed="";
  submit() {
    if(this.dataService.checkLogin()&&this.review) {
      let reviewAndRatings={
        message:this.review,
        ratings:4.0
      }
      let userId= this.dataService.getLocalStorage("id");
      this.dataService.postReview(this.bookId,userId,reviewAndRatings).subscribe((data:any)=>{
        this.feed="Thanks for give the feedback"
        this.review="";
        this.ngOnInit();
      })
    }else{
    this.feed="Write something feedback message"
    alert("Login First");
this.router.navigate(["login"]); 
     
    }
  }
books:any[]=[];
ngOnInit(): void {
  this.dataService.getReview(this.bookId).subscribe((data:any)=>{
this.reviewArr=data.body;
  })
}

constructor(private dataService: DataService, private route: ActivatedRoute,private router:Router) {
  this.route.params.subscribe(params => {
    this.bookId = params['id']; 
  });

  if(this.bookId!=0) {
this.dataService.saveLocalStorage("bookId",this.bookId);
  }else{
   this.bookId= this.dataService.getLocalStorage("bookId");
  }
  
  this.dataService.getAllBooks().subscribe((data: any) => {
    this.books = data; 
    for(let i=0;i<this.books.length;i++){
      if(this.books[i].bookId==this.bookId){
    this.title=this.books[i].title;
    this.image=this.books[i].image;
    this.author=this.books[i].author;
    this.genre=this.books[i].genre;
    this.description=this.books[i].description;
    this.price=this.books[i].price;
      }
     }
  });
}

wish() {
  if(this.dataService.checkLogin()) {
    let id:number=this.dataService.getLocalStorage("id");
    let bookId:number=this.dataService.getLocalStorage("bookId");
    
    this.dataService.addWishList(id,bookId).subscribe((data:any)=>{
      console.log(data);
       alert("Book Added");
    },
    (error) => {
      alert("The Book Already Added to your WishList");
      console.error(error);
    })
  }else{
alert("Login First");
this.router.navigate(["login"]);  
  }
}

reading() {
if(this.dataService.checkLogin()){

  let id:number=this.dataService.getLocalStorage("id");
  let bookId:number=this.dataService.getLocalStorage("bookId");
  
  this.dataService.addReadingList(id,bookId).subscribe((data:any)=>{
    console.log(data);
     alert("Book Added");
  },
  (error) => {
    alert("The Book Already Added to your Reading List");
    console.error(error);
  })
  }else{
    alert("Login First");
    this.router.navigate(["login"]);  
  }
}
buy(){
  if(this.dataService.checkLogin()){
this.bookId// title price
this.router.navigate(["payment",this.title,this.price]);  
  }else{
    alert("Login First");
    this.router.navigate(["login"]);  
  }
}
rent(){
  if(this.dataService.checkLogin()){
    this.bookId
    this.router.navigate(["payment",this.title,this.price,7]);  
      }else{
        alert("Login First");
        this.router.navigate(["login"]);  
      }

}
}
