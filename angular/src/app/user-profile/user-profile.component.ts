import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit{
  name="Username";
email="Username@gmail.com";
mobile="0123456789";

ReadingListArr:any[]=[];
WishListArr:any[]=[];
MyBooksArr:any[]=[];
 
deleteB=true;

ReadingList=true;
WishList=true;
MyBooks=true;
constructor(private route:Router,private dataService:DataService){
}

readingList(){
  this.deleteB=false;
  this.ReadingList=!this.ReadingList;
  if(!this.ReadingList){
     let userId=this.dataService.getLocalStorage("id");
 this.dataService.getReadingList(userId).subscribe((data:any)=>{
  this.ReadingListArr=data.body;
console.log(data.body);
})
  }
}
wishList(){
  this.deleteB=true;
  this.ReadingList=!this.ReadingList;
  if(!this.ReadingList){
     let userId=this.dataService.getLocalStorage("id");
 this.dataService.getWishList(userId).subscribe((data:any)=>{
  this.ReadingListArr=data.body;
})
  }
}

delete(id:any){
  let userId=this.dataService.getLocalStorage("id");
  this.dataService.deleteBookFromWishList(userId,id).subscribe((data:any)=>{
console.log(data);
this.wishList();
  })

}
  ngOnInit(): void {
    let userId=this.dataService.getLocalStorage("id");
    this.dataService.getUser(userId).subscribe((data:any)=>{
    this.email=  data.body.email;
    this.name=  data.body.name;
    this.mobile=  data.body.mobileNumber;
    });
  }

  logout(){
    this.dataService.removeDataLocalStorage();
    alert("Logout Successful");
    this.route.navigate([""]);  
  }
}
