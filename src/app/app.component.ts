import { Component, OnInit } from '@angular/core';
import { DataService } from './data.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Component-Binding';
  Login="Login";
 isLogin=false;
  constructor(private dataService:DataService,private route:Router){
  }
  log(){
    if(!this.isLogin){
      alert("Login First");
      this.route.navigate(["login"]);
    }else{
      this.route.navigate(["dis"]);
    }
  }
  log1(){
    if(!this.isLogin){
      alert("Login First");
      this.route.navigate(["login"]);
    }else{
      this.route.navigate(["chat"]);
    }
  }
  login(){
    if(this.isLogin){
      this.route.navigate(["userProfile"]);
    }else{
      this.route.navigate(["login"]);
    }
  }
  
  ngOnInit(): void {
    this.isLogin=this.dataService.checkLogin();
    if(this.isLogin){
      this.Login="Profile";
    }else{
      this.Login="Login"; 
    }
  }
}
